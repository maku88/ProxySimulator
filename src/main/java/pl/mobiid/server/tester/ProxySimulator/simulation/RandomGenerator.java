package pl.mobiid.server.tester.ProxySimulator.simulation;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 23.07.13
 * Time: 19:42
 * To change this template use File | Settings | File Templates.
 */
public class RandomGenerator {

     private Random random = new Random();

     public int getRandomInt(int limit) {
         return random.nextInt(limit);
     }

    public double getRandomDouble() {

        return round((random.nextGaussian()*0.2)+0.5,2);
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

}
