package pl.mobiid.server.tester.ProxySimulator.simulation;

import SymulationManager.remote.SimulationManager;
import org.junit.Test;
import org.mockito.Mockito;
import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.DBReader;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.math.BigInteger;
import java.security.SecureRandom;
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

//    @Test
//    public void testPrepareData() throws Exception {
//
//        SimulationManager mock = Mockito.mock(SimulationManager.class);
//
//        SysConfig.dbAddress="192.168.1.111:5432/mobi_prod";
//        int size = 10;
//        Simulator simulator = new Simulator(new DBReader(), size,"123",mock);
//        simulator.prepareData();
//
//        List<Tag> tagList = simulator.getListOfTags();
//
//        for(Tag s : tagList) {
//            System.out.println(s.toString());
//        }
//
//        assertTrue(tagList.size() == size);
//
//    }

    @Test
    public void test() {
        SecureRandom random = new SecureRandom();
        System.out.println((new BigInteger(130, random).toString(32)).substring(0,10).toUpperCase());


    }


}
