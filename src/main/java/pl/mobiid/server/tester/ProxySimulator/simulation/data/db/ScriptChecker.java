package pl.mobiid.server.tester.ProxySimulator.simulation.data.db;

import pl.mobiid.server.tester.ProxySimulator.simulation.data.SimulationResult;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 01.08.13
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class ScriptChecker implements Serializable {

    public boolean checkScript(SimulationResult result) {
        try {
            String dbScript = null;
            Connection connection = DBHelper.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select cc.default_script from client_services cs \n" +
                    "join client_campaign cc on cc.id = cs.campaign_id where cs.tag_id ='" +result.getTag().getTagId() + "'");
            while(rs.next()){
                dbScript = rs.getString("default_script");
            }

            st.close();
            rs.close();
            connection.close();

            return dbScript.equals(result.getResponse());

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
    }

}
