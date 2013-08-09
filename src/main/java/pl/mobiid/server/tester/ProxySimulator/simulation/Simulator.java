package pl.mobiid.server.tester.ProxySimulator.simulation;

import SymulationManager.manager.SimulationManager;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.*;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.ScriptChecker;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.files.FileWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */

@Component
public class Simulator {

    @Autowired SimulationManager manager;


    private int tagNumber =0;
    private SectionsFactory sectionsFactory = new SectionsFactory();
    @Getter private List<Tag> listOfTags = new ArrayList<Tag>();
    private RandomCollection<Sections> randomListOfSections = new RandomCollection<Sections>();
    private RandomCollection<Tag> randomListOfTags = new RandomCollection<Tag>();
    private List<SimulationResult> simulationResults = Collections.synchronizedList(new ArrayList());
    private DataWriter writer = new FileWriter("symulacja.txt");
    private ListMultimap<String, SimulationResult> tagReadResults = ArrayListMultimap.create();
    private Logger log = Logger.getLogger("symLogger");
    private ScriptChecker scriptChecker = new ScriptChecker();
    private String simulatorID ;

    public Simulator() {

    }

    public void setSimulation(DataReader reader , int size, String simulatorID) {
        this.tagNumber = size;
        loadTagList(reader,size);
        this.simulatorID = simulatorID;
        manager.registerSimulator(this.simulatorID);
    }

    public Simulator(DataReader reader , int size, String simulatorID) {
       this.tagNumber = size;
       loadTagList(reader,size);
        this.simulatorID = simulatorID;
        manager.registerSimulator(this.simulatorID);
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

    public void endSymulation() {
        //zapis podsumowania do logu
        showResults();

    }


    public Sections getRandomSection() {
        return randomListOfSections.next();
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

    public void showResults() {
        ListMultimap<Integer, Long> avgReadTimeMap = ArrayListMultimap.create();

        for(String s : tagReadResults.keySet()) {
            List<SimulationResult> r = tagReadResults.get(s);

            for(int i = 0 ; i<r.size() ; i++ ) {
               avgReadTimeMap.put(i+1,r.get(i).getDuration());
            }

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
