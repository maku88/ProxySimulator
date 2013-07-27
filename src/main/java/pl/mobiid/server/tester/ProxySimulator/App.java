package pl.mobiid.server.tester.ProxySimulator;

import pl.mobiid.server.tester.ProxySimulator.simulation.Simulator;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.DataReader;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.FileReader;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Sections;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;
import pl.mobiid.server.tester.ProxySimulator.threads.Conector;
import pl.mobiid.server.tester.ProxySimulator.threads.NotifyingThread;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadCompleteListener;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadListener;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App
{

    private static  Map<String, String> tagsMap = new HashMap<String, String>();
    private static String enpointLocal = "http://localhost:8080/rest/open/actions";
    private static String endpointTest = "http://morrigan.mobi-id.pl:8080/rest/open/actions";
    private static String endpointProd = "http://smarttouch.mobi-id.pl/rest/open/actions";
    private static DataReader reader = new FileReader("tagList.txt");

    public static void main( String[] args )
    {

        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "10000");

        String endpoint = null;

        if(args.length == 0 ) System.out.println("niepoprawny argument moze byc tylko prod albo test");
        else if(args[0].equals("prod")) endpoint = endpointProd;
        else if (args[0].equals("test")) endpoint = endpointTest;
        else if(args[0].equals("local")) endpoint = enpointLocal;
        else System.out.println("niepoprawny argument moze byc tylko prod albo test");

        System.out.println("endpoint : " + endpoint );


        if(endpoint != null ) {
            Simulator simulator = new Simulator(reader.read());
            simulator.prepareData();

            ThreadCompleteListener listener = new ThreadListener();
            int x = 0;
            while (x < 1000) {
//                Sections section = simulator.getRandomSection();
                Tag tag = simulator.getRandomTag();
                System.out.println("Wylosowałem sekcje : " + tag.getTagId());
                List<Tag> tagList = new ArrayList<Tag>();
                tagList.add(tag);
                // We will create 500 threads



                for (int i = 0; i < 1; i++) {
                    NotifyingThread task;
                    try {
                        Conector c  = new Conector(tagList, "thread ", endpoint, simulator );
                        c.run();
//                        task.addListener(listener);
//                        Thread worker = new Thread(task);
                        // We can set the name of the thread
//                        worker.setName(String.valueOf(i));
                        // Start the thread, never call method run() direct
//                        worker.start();
                        // Remember the thread for later usage
//                        listener.addThread(worker);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                x++;
            }

            while(true) {
                if (listener.allThreadsComplete()) {
                    simulator.writeLogFile();
                    simulator.showResults();
                    return;
                }
            }


        }
    }
}
