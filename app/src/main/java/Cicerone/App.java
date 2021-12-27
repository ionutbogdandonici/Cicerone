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
       ControllerGestisciArea controllerGestisciArea = new ControllerGestisciArea();
       System.out.println(controllerGestisciArea.getByToponimo("Cingoli").getID());

    }
}
