package pl.mobiid.server.tester.ProxySimulator.simulation;

import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 26.07.13
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public class TagFactory {

    private RandomGenerator generator = new RandomGenerator();

    public List<Tag> generateProbability(List<Tag> tags) {

        for(Tag t : tags) {
            t.setProbability(generator.getRandomDouble());
        }

        return tags;

    }
}
