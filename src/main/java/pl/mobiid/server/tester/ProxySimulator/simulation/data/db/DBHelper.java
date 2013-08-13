package pl.mobiid.server.tester.ProxySimulator.simulation.data.db;

import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 01.08.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
public class DBHelper implements Serializable {

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:postgresql://" + SysConfig.dbAddress, SysConfig.dbUser, SysConfig.dbPassword);
    }

}
