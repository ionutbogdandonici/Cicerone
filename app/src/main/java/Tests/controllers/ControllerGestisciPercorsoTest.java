package Tests.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Percorso;
import Cicerone.classes.Tappa;
import Cicerone.controllers.ControllerGestisciArea;
import Cicerone.controllers.ControllerGestisciPercorso;
import Cicerone.db.DB_Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

class ControllerGestisciPercorsoTest {

    @Test
    void insertDB() throws SQLException {
        DB_Controller.init();
        Percorso daInserire = new Percorso("134", "Giovedi sera serata!");
        Percorso daInserire1 = new Percorso("134", "Giovedi sera serata!");
        ControllerGestisciPercorso controllerGestisciPercorso = new ControllerGestisciPercorso();
        controllerGestisciPercorso.insertDB(daInserire);
        controllerGestisciPercorso.insertDB(daInserire1);

        ControllerGestisciArea gestisciArea = new ControllerGestisciArea();
        Percorso daInserireConTappe = new Percorso("Arrampicata", "Arrampicata sul monte Vettore con istruttore");

        Tappa tappa1 = new Tappa("Partenza", "Partenza da Porto Recanati", "Macchina", gestisciArea.getById("5"));
        Tappa tappa2 = new Tappa("Pranzo", "Pranzo a sacco preso la Rocca", "Bus", gestisciArea.getById("7"));
        Tappa tappa3 = new Tappa("Attività Arrampicata", "Arrampicata preso la palestra di Tolentino", "Bus", gestisciArea.getById("2"));

        daInserireConTappe.addTappa(tappa1);
        daInserireConTappe.addTappa(tappa2);
        daInserireConTappe.addTappa(tappa3);

        controllerGestisciPercorso.insertDB(daInserireConTappe);
    }

    @Test
    void getAllData() throws SQLException {
        DB_Controller.init();
        ControllerGestisciPercorso controllerGestisciPercorso = new ControllerGestisciPercorso();
        Set<Percorso> toCheck = controllerGestisciPercorso.getAllData();

        for (Percorso percorso : toCheck) {
            System.out.println(percorso);
        }

        System.out.println(toCheck);
    }

    @Test
    void getById() {
    }

    @Test
    void getByName() {
    }

    @Test
    void refreshData() {
    }

    @Test
    void checkDB() {
    }
}