package pl.mobiid.server.tester.ProxySimulator.simulation;

import org.junit.Before;
import org.junit.Test;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Sections;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class SimulatorTest {

    List<Tag> tagList = new ArrayList<Tag>();
    private int tagNumber = 100;

    @Before
    public void initTagList() {

        for(int i = 1; i<tagNumber; i++ ) {
            tagList.add(new Tag("Znacznik : " + i,"",0));
        }

    }


    @Test
    public void testPrepareData() throws Exception {
        Simulator simulator = new Simulator(tagList);
        simulator.prepareData();

//        List<Sections> sections = simulator.getListOfSections();
//
//        for(Sections s : sections) {
//            System.out.println(s.toString());
//        }
//
//        assertTrue(sections.size()>0);

    }


}
