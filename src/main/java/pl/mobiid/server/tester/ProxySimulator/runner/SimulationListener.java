package pl.mobiid.server.tester.ProxySimulator.runner;

import SymulationManager.remote.SimulationManager;
import pl.mobiid.server.tester.ProxySimulator.simulation.Simulator;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 13.08.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public interface SimulationListener {

    void startSimulation(Simulator simulator, String endpoint, SimulationManager manager);
    void stopSimulation();

}
