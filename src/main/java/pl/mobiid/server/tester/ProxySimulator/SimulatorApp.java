package pl.mobiid.server.tester.ProxySimulator;

import SymulationManager.remote.SimulationManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.runner.SimulationListener;
import pl.mobiid.server.tester.ProxySimulator.runner.SimulationRunner;
import pl.mobiid.server.tester.ProxySimulator.simulation.Simulator;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.*;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.DBReader;
import pl.mobiid.server.tester.ProxySimulator.threads.Connector;
import pl.mobiid.server.tester.ProxySimulator.threads.NotifyingThread;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadCompleteListener;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadListener;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Hello world!
 *
 */
@Component
public class SimulatorApp implements Serializable
{

    private static Map<String, String> tagsMap = new HashMap<String, String>();
    private static String enpointLocal = "http://localhost:8080/rest/open/actions";
    private static String endpointTest = "http://morrigan.mobi-id.pl:8080/rest/open/actions";
    private static String endpointProd = "http://smarttouch.mobi-id.pl/rest/open/actions";
    private static DataReader reader = new DBReader();
    private static Logger log = Logger.getLogger(SimulatorApp.class);
    private SimulationListener simulationRunner;
    String endpoint = null;
    private boolean waitForMsg = true;


    @Autowired Simulator simulator;
    @Autowired SimulationManager manager;
    RemoteSimulatorImpl remoteSimulator;

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimulatorApp p = context.getBean(SimulatorApp.class);
        log.info("WAITING FOR SETUP MESSAGE");
        p.init(args);
    }

    private void init(String[] args) {

        if(args.length < 5 ) log.error("niepoprawny argument ! podaj [hostSerwera] [hostProxy:port ] [adresBazy] [id symulatora]");
        else if(args[0].equals("prod")) endpoint = endpointProd;
        else if (args[0].equals("test")) endpoint = endpointTest;
        else if(args[0].equals("local")) endpoint = enpointLocal;
        else {
            endpoint = "http://" + args[0] + ":8080/rest/open/actions";

            String[] hostAndProt = args[1].split(":");

            SysConfig.proxyHost = hostAndProt[0];
            SysConfig.proxyPort= Integer.parseInt(hostAndProt[1]);

        }

        SysConfig.dbAddress = args[2];
        SysConfig.simulatorID = args[3];

        if(args[4].equals("single")) {
            startSimulation(Integer.parseInt(args[5]), Integer.parseInt(args[6]), 1);
        }

        simulationRunner  = new SimulationRunner();

        remoteSimulator = new RemoteSimulatorImpl(SysConfig.simulatorID);

        registerRemoteSimulator();

        while(waitForMsg) {
            if(remoteSimulator.isStartFlag()) {
                remoteSimulator.setStartFlag(false);
                waitForMsg = false;
                startSimulation(remoteSimulator.getNumberOfTags(),remoteSimulator.getNumberOfRequests(),remoteSimulator.getSimulationID());
            }
        }
    }

    private void startSimulation(int numberOfTags, int numberOfRequests, int simulationID) {
        log.info(">> SETUP MESSAGE << ");
        log.info("numberOfTags " + numberOfTags);
        log.info("numberOfRequests " + numberOfRequests);
        SysConfig.tagNumber = numberOfTags;
        SysConfig.numberOfRequests = numberOfRequests;
        simulator.setupSimulation(reader, SysConfig.tagNumber, SysConfig.simulatorID,numberOfRequests,simulationID);
        simulator.prepareData();

        simulationRunner.startSimulation(simulator,endpoint,manager);

        waitForMsg = true;

    }

    private void registerRemoteSimulator() {
        try {
            RemoteSimulator stub = (RemoteSimulator) UnicastRemoteObject.exportObject(remoteSimulator, 0);
            manager.registerSimulator(stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
