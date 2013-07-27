package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */

@Data
@AllArgsConstructor
public class Sections {
    private String sectionNumber;
    private double probability;
    private int tagNumber;
    @Getter private final List<Tag> listOfTags = new ArrayList<Tag>();

    public void addToList(Tag tag) {
        if( tag == null ) throw new NullPointerException("null");
        listOfTags.add(tag);
    }

    @Override
    public String toString() {
        return "Sections{" +
                "sectionNumber='" + sectionNumber + '\'' +
                ", probability=" + probability +
                ", tagNumber=" + tagNumber +
                ", listOfTagsSize=" + listOfTags.size() +
                '}';
    }
}
