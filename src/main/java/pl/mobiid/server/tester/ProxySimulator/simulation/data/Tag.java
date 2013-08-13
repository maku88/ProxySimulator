package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */

@Data
@ToString
public class Tag implements Serializable {

    private String tagId;
    private String script;
    private double probability;
    private int readCount;

    public Tag(String tagId, String script, double probability) {
        this.tagId = tagId;
        this.script = script;
        this.probability = probability;
    }

    public void incrementReadTime() {
        readCount++;
    }




}
