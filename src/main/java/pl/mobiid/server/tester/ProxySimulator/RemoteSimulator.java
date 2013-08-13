package pl.mobiid.server.tester.ProxySimulator;

import java.rmi.Remote;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 12.08.13
 * Time: 00:19
 * To change this template use File | Settings | File Templates.
 */
public interface RemoteSimulator extends Remote{

    public void startSimulation(int numberOfTags, int numberOfRequests , int simulationID) throws java.rmi.RemoteException;

    public String getSimulatorID() throws java.rmi.RemoteException;


}
