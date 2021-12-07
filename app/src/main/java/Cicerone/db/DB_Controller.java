package Cicerone.db;

import java.sql.*;

public class DB_Controller {

    private static final String url = "jdbc:mysql://localhost:3306/cicerone";
    private static final String username = "root";
    private static final String password = "";
    private static Connection con;

    public static boolean initTest() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected!");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Not connected", e);
        }
    }

    public static void query(String query) throws SQLException {
        if (initTest()) {
            con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("ID | Nome");
            System.out.println("----------------");
            while(rs.next()){
                //Display values
                System.out.print(rs.getString("ID_TAG"));
                System.out.print("  | ");
                System.out.print(rs.getString("Nome"));
                System.out.print("\n");
            }
        } else {
            throw new IllegalStateException("Impossibile eseguire query, DB non accessibile!");
        }
    }
}
