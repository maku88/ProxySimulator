package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class FileWriter implements DataWriter{

    private final String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<SimulationResult> resultList) {

        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for(SimulationResult result : resultList) {
                writer.println(result.getString());
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
