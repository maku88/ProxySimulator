package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import pl.mobiid.shared.datatypes.communication.common.JsonActionToHandleResponse;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
@Data
public class SimulationResult implements Serializable {

    private String threadName;
    private Tag tag;
    private long startTimestamp;
    private long endTimestamp;
    private long duration;
    private String response;
    private boolean isResponseCorrect;


    public SimulationResult(String threadName, Tag tag, long startTimestamp, long endTimestamp, long duration, String response) {
        this.threadName = threadName;
        this.tag = tag;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.duration = duration;
        setResponse(response);
    }

    public String getString() {
        return  "RES;"+tag.getTagId() + ";" +tag.getProbability()+";"+tag.getReadCount() + ";"+ startTimestamp +";" + endTimestamp +";" + duration + ";" + isResponseCorrect;
    }



    public void setResponse(String response ) {
        if(response != null) this.response = response.replace("mScenario=","");
    }


    @Override
    public String toString() {
        return  "RES;"+tag.getTagId() + ";" +tag.getProbability()+ ";" + tag.getReadCount() + ";" + startTimestamp +";" + endTimestamp +";" + duration + ";" + isResponseCorrect + ";" + response;
    }
}
