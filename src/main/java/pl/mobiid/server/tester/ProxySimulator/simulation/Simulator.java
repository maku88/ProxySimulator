package pl.mobiid.server.tester.ProxySimulator.simulation;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.sun.xml.internal.txw2.DatatypeWriter;
import lombok.Getter;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public class Simulator {

    private int tagNumber =0;
    private SectionsFactory sectionsFactory = new SectionsFactory();
    @Getter private List<Sections> listOfSections = new ArrayList<Sections>();
    private List<Tag> listOfTags = new ArrayList<Tag>();
    private RandomCollection<Sections> randomListOfSections = new RandomCollection<Sections>();
    private RandomCollection<Tag> randomListOfTags = new RandomCollection<Tag>();
    private List<SimulationResult> simulationResults = Collections.synchronizedList(new ArrayList());
    private DataWriter writer = new FileWriter("symulacja.txt");
    private ListMultimap<String, SimulationResult> tagReadResults = ArrayListMultimap.create();

    public Simulator(List<Tag> tags) {
       this.tagNumber = tags.size();
       this.listOfTags = tags;
    }


    public void prepareData() {

//        listOfSections = sectionsFactory.generateSectionsForTags(listOfTags);
//
//        for(Sections s : listOfSections) {
//            randomListOfSections.add(s.getProbability(),s);
//        }
//
//        for(Sections s : listOfSections) {
//            System.out.println(s.toString());
//        }

        TagFactory f = new TagFactory();
        listOfTags = f.generateProbability(listOfTags);

        for(Tag t : listOfTags) {

            randomListOfTags.add(t.getProbability(),t);
        }

    }

    public Sections getRandomSection() {
        return randomListOfSections.next();
    }

    public Tag getRandomTag() {
        return randomListOfTags.next();
    }

    public synchronized void addResult(SimulationResult result) {
//        System.out.println("Adding : " +result.toString());
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

            System.out.println("tag: " + s + " odczytow : " + r.size() + " sr czas " + avgTime);
        }

        for(Integer readCount : avgReadTimeMap.keySet()) {

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
