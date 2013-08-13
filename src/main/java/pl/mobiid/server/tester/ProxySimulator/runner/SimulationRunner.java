package pl.mobiid.server.tester.ProxySimulator.runner;

import SymulationManager.remote.SimulationManager;
import org.apache.log4j.Logger;
import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.simulation.Simulator;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;
import pl.mobiid.server.tester.ProxySimulator.threads.Connector;
import pl.mobiid.server.tester.ProxySimulator.threads.NotifyingThread;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadCompleteListener;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadListener;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 13.08.13
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 */
public class SimulationRunner implements SimulationListener {

    private static Logger log = Logger.getLogger(SimulationRunner.class);
    private String endpoint;
    private SimulationManager manager;
    private Simulator simulator;
    private boolean flag;


    @Override
    public void startSimulation(Simulator simulator, String endpoint, SimulationManager manager){
        this.simulator = simulator;
        this.manager = manager;
        this.endpoint = endpoint;
        start();
    }

    @Override
    public void stopSimulation() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private void start() {
        log.info("---------------");
        log.info("SIMULATOR START");
        log.info(SysConfig.printConfig());
        if(endpoint != null ) {
            for (int requestCounter = 0 ; requestCounter < simulator.getNumberOfRequests(); requestCounter++) {
                Tag tag = simulator.getRandomTag();
                log.info("TAG : " + tag.getTagId() + " " + tag.getProbability());
                List<Tag> tagList = new ArrayList<Tag>();
                tagList.add(tag);

                for (int i = 0; i < 1; i++) {
                    NotifyingThread task;
                    try {
                        Connector c  = new Connector(tagList, "thread", endpoint, simulator);
                        c.doRun();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.info("END OF SIMULATION");
            log.info("WAITING FOR SETUP MESSAGE");
            log.info("-------------------------");
            simulator.endSimulation(manager);
        }
    }


}
