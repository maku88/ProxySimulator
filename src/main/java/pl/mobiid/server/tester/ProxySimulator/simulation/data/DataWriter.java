package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public interface DataWriter {

    public void write(List<SimulationResult> resultList);
}
