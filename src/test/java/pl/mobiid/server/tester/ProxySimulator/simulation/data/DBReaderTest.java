package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import org.junit.Test;
import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.DBReader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 01.08.13
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 */
public class DBReaderTest {


    @Test
    public void testRead() throws Exception {

        SysConfig.dbAddress="192.168.1.105:5432/mobi_prod";
        DataReader reader = new DBReader();

        List<Tag> list = reader.read();


        for(Tag t : list) {
            System.out.println(t.toString());
        }



    }
}
