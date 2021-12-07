package Cicerone.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Controller {

    private static final String url = "jdbc:mysql://localhost:3306/cicerone";
    private static final String username = "root";
    private static final String password = "";

    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Not connected", e);
        }
    }
}
