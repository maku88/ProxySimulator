package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import pl.mobiid.shared.datatypes.communication.common.JsonActionToHandleResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@ToString
public class SimulationResult {

    private String threadName;
    private Tag tag;
    private long startTimestamp;
    private long endTimestamp;
    private long duration;
    private JsonActionToHandleResponse response;


    public String getString() {
        return "{" +
                ", tag=" + tag.getTagId() +
                ", s=" + startTimestamp +
                ", e=" + endTimestamp +
                ", d=" + duration +
                '}';
    }
}
