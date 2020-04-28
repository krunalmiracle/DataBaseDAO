package edu.upc.eetac.dsa;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//IMPLEMENTED !!
public class FactorySession {
    public static Session openSession() {
        try
        {
            // Create Properties object.
            Properties databaseProperties = new Properties();
            String dbSettingsPropertyFile = "src/main/resources/JDBCSettings.properties";
            // Properties will use a FileReader object as input.
            FileReader fReader = new FileReader(dbSettingsPropertyFile);
            // Load jdbc related properties in above file.
            databaseProperties.load(fReader);
            // Get each property value of DataBase.
            String host = databaseProperties.getProperty("db.host");
            int port = (Integer.getInteger(databaseProperties.getProperty("db.port"))) ;
            String dataBase = databaseProperties.getProperty("db.database");
            String user = databaseProperties.getProperty("db.username");
            String pass = databaseProperties.getProperty("db.password");

            if("".equals(host))
            {
                Connection conn = getConnection(host,port,dataBase,user,pass);
                Session session = new SessionImpl(conn);
                return session;
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }


        return null;
    }

    private static Connection getConnection(String host, int port, String dataBase,String user, String pass) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://"+host+":"+port+"/"+
                dataBase+"?user="+user+"&password"+pass);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
