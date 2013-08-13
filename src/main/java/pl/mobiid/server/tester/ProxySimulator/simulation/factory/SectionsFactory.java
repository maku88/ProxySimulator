package pl.mobiid.server.tester.ProxySimulator.simulation.factory;

import pl.mobiid.server.tester.ProxySimulator.simulation.RandomGenerator;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Sections;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class SectionsFactory {

    private RandomGenerator generator = new RandomGenerator();
    private int pozostalo=0;
    private double pozostaloProb = 1;
    private List<Sections> listOfSections = new ArrayList<Sections>();
    private int sectionNumber =0;
    private List<Tag> tagList = new ArrayList<Tag>();

    public List<Sections> generateSectionsForTags(List<Tag> tags) {
        this.pozostalo = tags.size();
        this.tagList = tags;

        generateSections();

        for(int i = 0; i<listOfSections.size();i++) {
            Sections s = listOfSections.get(i);

            boolean isLastElem = false;
            if(i == listOfSections.size()-1) isLastElem = true;

            s.setProbability(generateProbForSection(isLastElem));
        }


        assignTagsToSections();

      return listOfSections;
    }

    private void assignTagsToSections() {
        for(Sections s : listOfSections) {

            for(int a = 1; a <= s.getTagNumber(); a++) {
                Tag tag = tagList.get(generator.getRandomInt(tagList.size()));
                tagList.remove(tag);
                s.addToList(tag);
            }
        }
    }

    private void generateSections() {

        /**
         * 1. wylosuj liczbę x od 1 do n
         2. jeżeli x < n to dodaj do zmniejsz n o x, zapisz sobie x losuj dalej
         3. jeżeli x = n to skończ losowanie, zapisz sobie x
         4. jeżeli x > n to olej, losuj dalej
         */
        int x = generator.getRandomInt(pozostalo) +1;
//        System.out.println("wylosowalem : " + x + " pozostalo " + pozostalo );

        if(x < pozostalo) {
            createSection(x);
            pozostalo -= x;
            generateSections();
        }else if(x == pozostalo) {
            createSection(x);
            return;
        }else if(pozostalo == 1) {
            createSection(1);
            return;
        }else {
            generateSections();
        }
    }


    private double generateProbForSection(boolean isLastElem) {

        double p = generator.getRandomDouble();
//        System.out.println("wylosowalem p : " + p + " pozostalo " + pozostaloProb );

        if(isLastElem) {
            return generator.round(pozostaloProb, 2);
        }

        if(p < pozostaloProb) {
            pozostaloProb -= p;
            return p;
        }else if(p == pozostaloProb) {
            return p;
        }else {
            return generateProbForSection(isLastElem);
        }
    }

    private void createSection(int size) {
        Sections s = new Sections("Sekcja : " + sectionNumber,0,size);
        listOfSections.add(s);
        sectionNumber++;
    }


}
