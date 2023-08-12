package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cars_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "*****";


    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection closeConnection(Connection connection){
     //   Connection connection = null;
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
