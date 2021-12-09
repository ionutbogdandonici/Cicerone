package Cicerone.db;

import java.sql.*;

public class DB_Controller{

    private static final String url = "jdbc:mysql://localhost:3306/cicerone";
    private static final String username = "root";
    private static final String password = "";
    private static Connection conn;


    public static void init(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            conn =  DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");

        } catch (SQLException e) {
            throw new IllegalStateException("Not connected", e);
        }
    }



    // Ritorna true se ha almeno una riga, false se non
    public static boolean ifExistQuery(String query) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(query);
        System.out.println(set);
        return true;
    }
}
