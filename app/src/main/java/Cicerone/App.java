package Cicerone;

import Cicerone.classes.Percorso;
import Cicerone.classes.Territorio;
import Cicerone.controllers.ControllerGestisciArea;
import Cicerone.controllers.ControllerGestisciPercorso;
import Cicerone.controllers.ControllerGestisciTappa;
import Cicerone.controllers.ControllerGestisciTerritorio;
import Cicerone.db.DB_Controller;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        DB_Controller.init();
        ControllerGestisciPercorso con = new ControllerGestisciPercorso();
        ControllerGestisciTerritorio con1 = new ControllerGestisciTerritorio();
        Territorio v = new Territorio("Ancona", "Marche");
        con1.insertDB(v);
         //con.insertInDB("Ancona", "Ancona");
        // con.insertInDB("Cingoli", "Macerata");
        // con.insertInDB("Tolentino", "Macerata");
        // con.insertInDB("Agosta", "Roma");*/
        // con.insertInDB("Treia", "Macerata");
        // con.insertInDB("Visso", "Macerata");
        // System.out.println(con.toString());
        // ControllerGestisciTappa controllerGestisciTappa = new ControllerGestisciTappa();
        // controllerGestisciTappa.insertInDb("Porto", "Imbarco", "Bus", "Porto Recanati");
        // controllerGestisciTappa.insertInDb("Porto", "Imbarco", "Bus", "Ancona");
        Percorso a = new Percorso("daje","daje de tacco");
        con.insertDB(a);

        Percorso daInserire = new Percorso("134", "Giovedi sera serata!");
        ControllerGestisciPercorso controllerGestisciPercorso = new ControllerGestisciPercorso();
        controllerGestisciPercorso.insertDB(daInserire);


    }
}
