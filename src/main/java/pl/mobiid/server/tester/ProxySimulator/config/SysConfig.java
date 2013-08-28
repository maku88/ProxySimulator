package pl.mobiid.server.tester.ProxySimulator.config;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class SysConfig implements Serializable{

    public static String proxyHost = "0.0.0.0";
    public static int proxyPort  = 10000;
    public static String dbAddress;
    public static int tagNumber;
    public static String dbUser = "postgres";
    public static String dbPassword = "niewiem2009";
    public static int numberOfRequests = 1000;
    public static String simulatorID;
    public static String logID;
    public static boolean proxyEnabled = true;

    public static String printConfig() {
        return "\n"
             + "proxyHost : " + proxyHost + ":" + proxyPort + "\n"
             + "dbAddress : " + dbAddress + "\n"
             + "tagNumber : " + tagNumber + "\n"
             + "dbUser : " + dbUser + "\n"
             + "dbPassword : " + dbPassword + "\n"
             + "numberOfRequests : " + numberOfRequests + "\n"
             + "simulatorID : " + simulatorID + "\n";
    }


}
