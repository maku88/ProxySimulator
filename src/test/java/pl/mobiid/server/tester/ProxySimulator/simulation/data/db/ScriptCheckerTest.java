//package pl.mobiid.server.tester.ProxySimulator.simulation.data.db;
//
//import org.junit.Test;
//import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
//import pl.mobiid.server.tester.ProxySimulator.simulation.data.SimulationResult;
//import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;
//import static org.junit.Assert.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: Maciek
// * Date: 01.08.13
// * Time: 22:43
// * To change this template use File | Settings | File Templates.
// */
//public class ScriptCheckerTest {
//    @Test
//    public void testCheckScript() throws Exception {
//       SysConfig.dbAddress="192.168.1.111:5432/mobi_prod";
//       ScriptChecker checker = new ScriptChecker();
//
//        Tag t = new Tag("TROM92590K","aaa",0);
//
//        SimulationResult result = new SimulationResult("",t,0,0,0,"aaa");
//
//        assertTrue(checker.checkScript(result));
//
//
//
//    }
//}
