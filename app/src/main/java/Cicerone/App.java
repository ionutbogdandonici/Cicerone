package Cicerone;

import Cicerone.controllers.ControllerGestisciTerritorio;
import Cicerone.db.DB_Controller;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM tag";
        DB_Controller.init();
        ControllerGestisciTerritorio co = new ControllerGestisciTerritorio();
        System.out.println(co.insertInDB("Bari", "Puglia"));
        //DB_Controller.query(query);
    }
}
