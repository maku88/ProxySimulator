package pl.mobiid.server.tester.ProxySimulator.simulation.data.db;

import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.DataReader;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.db.DBHelper;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 01.08.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class DBReader implements DataReader {


    @Override
    public List<Tag> read() {
        List<Tag> returnList = new ArrayList<Tag>();
        try {
            Connection connection = DBHelper.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select cs.tag_id, cc.default_script from client_services cs \n" +
                    "join client_campaign cc on cc.id = cs.campaign_id");
            while(rs.next()){
                String tagId 	= rs.getString("tag_id");
                String script 	= rs.getString("default_script");
                returnList.add(new Tag(tagId,script,0));
            }

            st.close();
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return returnList;
    }
}
