package Cicerone;

import Cicerone.controllers.ControllerGestisciArea;
import Cicerone.controllers.ControllerGestisciTappa;
import Cicerone.controllers.ControllerGestisciTerritorio;
import Cicerone.db.DB_Controller;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        DB_Controller.init();
        ControllerGestisciArea con = new ControllerGestisciArea();
        con.insertInDB("Porto Recanati", "Macerata");
        //con.insertInDB("Cingoli", "Macerata");
        //con.insertInDB("Tolentino", "Macerata");
        //con.insertInDB("Agosta", "Roma");*/
        //con.insertInDB("Treia", "Macerata");
        //con.insertInDB("Visso", "Macerata");
        //System.out.println(con.toString());
        ControllerGestisciTappa controllerGestisciTappa = new ControllerGestisciTappa();
        controllerGestisciTappa.insertInDb("Porto", "Imbarco", "Bus", "Porto Recanati");



    }
}
