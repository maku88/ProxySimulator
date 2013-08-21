package pl.mobiid.server.tester.ProxySimulator.data.generator;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 31.07.13
 * Time: 00:09
 * To change this template use File | Settings | File Templates.
 */
public class DataGenerator implements Serializable {
    private static SecureRandom random = new SecureRandom();
    private static int counter=10;


    public static void main(String[] args) throws ClassNotFoundException {

        for(int i = 0; i<1000;i++) {
            insertIntoDB(generateTag(),generateScript(),generateCampaignName());
        }



    }

    private static String generateCampaignName() {
        String n = "Kampania " + counter;
        counter++;
        return n;
    }


    private static String generateTag() {
       return (new BigInteger(130, random).toString(32)).substring(0,10).toUpperCase();
    }

    public static String generateScript() {
        String script = "{\"condition\":{\"mConditionType\":0,\"mExpectedValue\":\"\"},\"trueActionGroup\":[{\"id\":111,\"mActionType\":8,\"mActionParams\":{\"1\":\"%s\",\"99\":\"%s\"}}],\"falseActionGroup\":[],\"nextTrue\":null,\"nextFalse\":null}";

        String randomName = generateTag().substring(0,5);

        return String.format(script,randomName,randomName);

    }



    public static void insertIntoDB(String tag, String script, String campaignName) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        String url = "jdbc:postgresql://192.168.1.114:5432/mobi";
        String user = "postgres";
        String password = "niewiem2009";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();


            String query = "insert into client_campaign (short_name,creation_date,owner_id,creator_id,is_active,start_date,default_script,state) " +
                    "values ('"+campaignName+"',now(),123,123,'t',now(),'"+script+"','ACTIVE');" +
                    "insert into client_services (tag_id,owner_id,is_authorization_required,expire_date,campaign_id)" +
                    "values ('"+tag+"',123,'f','2014-01-01',(select id from client_campaign  where short_name = '"+campaignName+"') )";


            st.executeUpdate(query);

//            if (rs.next()) {
//                System.out.println(rs.getString(1));
//            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


}


}
