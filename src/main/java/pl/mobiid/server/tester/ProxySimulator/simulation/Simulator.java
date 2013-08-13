package pl.mobiid.server.tester.ProxySimulator.simulation;

import SymulationManager.remote.SimulationManager;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.*;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.ScriptChecker;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.files.FileWriter;
import pl.mobiid.server.tester.ProxySimulator.simulation.factory.TagFactory;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */

@Component
public class Simulator {

    private int tagNumber =0;
    @Getter private int numberOfRequests = 0;
    @Getter private List<Tag> listOfTags = new ArrayList<Tag>();
    private RandomCollection<Tag> randomListOfTags = new RandomCollection<Tag>();
    private List<SimulationResult> simulationResults = Collections.synchronizedList(new ArrayList());
    private ListMultimap<String, SimulationResult> tagReadResults = ArrayListMultimap.create();

    private DataWriter writer = new FileWriter("symulacja.txt");
    private Logger log = Logger.getLogger("symLogger");
    private ScriptChecker scriptChecker = new ScriptChecker();
    private String simulatorID ;
    private int simulationID;

    public Simulator() {

    }

    public void setupSimulation(DataReader reader, int size, String simulatorID, int numberOfRequests, int simulationID) {
        listOfTags.clear();
        randomListOfTags = new RandomCollection<Tag>();
        simulationResults.clear();
        tagReadResults.clear();
        this.tagNumber = size;
        loadTagList(reader,tagNumber);
        this.simulatorID = simulatorID;
        this.simulationID = simulationID;
        this.numberOfRequests = numberOfRequests;
    }

    public Simulator(DataReader reader , int size, String simulatorID, SimulationManager manager) {
       this.tagNumber = size;
       loadTagList(reader,tagNumber);
        this.simulatorID = simulatorID;
//        manager.registerSimulator(this.simulatorID);
    }

    private void loadTagList(DataReader reader , int size) {

        List<Tag> list = reader.read();

        Random random = new Random();

        for(int i = 0; i<size ; i++) {
            int index = random.nextInt(list.size());
            Tag t = list.get(index);
            list.remove(t);
            listOfTags.add(t);
        }
    }


    public void prepareData() {

        TagFactory f = new TagFactory();
        listOfTags = f.generateProbability(listOfTags);

        for(Tag t : listOfTags) {

            randomListOfTags.add(t.getProbability(),t);
        }

    }

    public void endSimulation(SimulationManager manager) {
        writeLogFile();
        showResults();
        manager.reportFinish(simulatorID,calculateReadStats(tagReadResults),calculateMistakesStats(simulationResults),simulationID);
    }


    public Tag getRandomTag() {
        return randomListOfTags.next();
    }

    public synchronized void addResult(SimulationResult result) {

        boolean isResponseCorrect  = scriptChecker.checkScript(result);
        result.setResponseCorrect(isResponseCorrect);


        log.info(result.toString());
        simulationResults.add(result);
        tagReadResults.put(result.getTag().getTagId(),result);
    }

    public void writeLogFile() {
        System.out.println("size : " + simulationResults.size());
        writer.write(simulationResults);
    }


    Map<Integer,Long> calculateReadStats(ListMultimap<String, SimulationResult> tagReadResults) {

        Map<Integer,Long> reutrnMap = new HashMap<Integer, Long>();

        ListMultimap<Integer, Long> avgReadTimeMap = ArrayListMultimap.create();

        for(String tagID : tagReadResults.keySet()) {
            List<SimulationResult> tagResults = tagReadResults.get(tagID);

            for(int i = 0 ; i<tagResults.size() ; i++ ) {
                avgReadTimeMap.put(i + 1, tagResults.get(i).getDuration());
            }
        }


        //wyliczam sredni czas odczytow
        for(Integer readCount : avgReadTimeMap.keySet()) {

            List<Long> avgList = avgReadTimeMap.get(readCount);

            long avgTime = 0;
            for(Long l : avgList) {
                avgTime+=l;
            }

            avgTime = avgTime/avgList.size();

            reutrnMap.put(readCount,avgTime);
        }

        return reutrnMap;

    }


    int calculateMistakesStats(List<SimulationResult> simulationResults) {

        int numberOfMistakes = 0;

        for(SimulationResult result : simulationResults) {
            if(result.isResponseCorrect() == false ) numberOfMistakes++;
        }

        return numberOfMistakes;
    }


    public void showResults() {
        ListMultimap<Integer, Long> avgReadTimeMap = ArrayListMultimap.create();

        for(String s : tagReadResults.keySet()) {
            List<SimulationResult> r = tagReadResults.get(s);

            for(int i = 0 ; i<r.size() ; i++ ) {
               avgReadTimeMap.put(i+1,r.get(i).getDuration());
            }

            //wyliczam sredni czas odczytow na znaczniku
            long avgTime = 0;
            for(SimulationResult sr : r) {
                avgTime+=sr.getDuration();
            }

            avgTime = avgTime/r.size();

            log.info("tag: " + s + " odczytow : " + r.size() + " sr czas " + avgTime);
        }

        for(Integer readCount : avgReadTimeMap.keySet()) {

            List<Long> avgList = avgReadTimeMap.get(readCount);


            long avgTime = 0;
            for(Long l : avgList) {
                avgTime+=l;
            }

            avgTime = avgTime/avgList.size();

            log.info("odczyt " + readCount + " sr czas " + avgTime);

        }


    }


    private void lottoSection() {
//        int totalSum = 0;
//
//        for(Sections item : listOfSections) {
//            totalSum = totalSum + item.getProbability();
//        }
//
//        int index = random.nextInt(totalSum);
//        System.out.println("index : " +index);
//
//        int sum = 0;
//        int i=0;
//        while(sum < index ) {
//            sum = sum + listOfSections.get(i++).getProbability();
//        }
//
////        System.out.println("---- " + (i-1));
//        System.out.println(listOfSections.get(i - 1).toString());
    }

//    private boolean countNumbers(int lastNumber) {
//        int sum = 0;
//
//        for(int i : sectionsSize ){
//            sum += i;
//        }
//
//        if(sum + lastNumber >tagNumber) return false;
//        else if(sum + lastNumber == tagNumber) {
//            sectionsSize.add(lastNumber);
//            return false;
//        }else {
//            sectionsSize.add(lastNumber);
//            return true;
//        }
//
//    }


}
