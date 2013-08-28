package pl.mobiid.server.tester.ProxySimulator.simulation.data.files;

import pl.mobiid.server.tester.ProxySimulator.simulation.data.SimulationResult;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 25.08.13
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
public class TagWriter {

    public void write(List<Tag> resultList, String fileName) {

        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for(Tag t : resultList) {
                writer.println(t.getString());
            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
