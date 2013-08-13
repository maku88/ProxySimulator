package pl.mobiid.server.tester.ProxySimulator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 13.08.13
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */

public class RemoteSimulatorImpl implements RemoteSimulator, Serializable {

    private String simulatorID;
    private boolean startFlag = false;
    private int numberOfTags;
    private int numberOfRequests;
    private int simulationID;


    public RemoteSimulatorImpl(){}

    public RemoteSimulatorImpl(String simulatorID) {
        this.simulatorID = simulatorID;
    }

    public void startSimulation(int numberOfTags, int numberOfRequests, int simulationID) {
        this.startFlag = true;
        this.simulationID = simulationID;
        this.numberOfRequests =numberOfRequests;
        this.numberOfTags = numberOfTags;
        System.out.println("start");
    }


    public String getSimulatorID() {
        return this.simulatorID;
    }

    public void setSimulatorID(String simulatorID) {
        this.simulatorID = simulatorID;
    }

    public boolean isStartFlag() {
        return startFlag;
    }

    public void setStartFlag(boolean startFlag) {
        this.startFlag = startFlag;
    }

    public int getNumberOfTags() {
        return numberOfTags;
    }

    public void setNumberOfTags(int numberOfTags) {
        this.numberOfTags = numberOfTags;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getSimulationID() {
        return simulationID;
    }

    public void setSimulationID(int simulationID) {
        this.simulationID = simulationID;
    }
}
