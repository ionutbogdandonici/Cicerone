package Tests.controllers;

import Cicerone.classes.Percorso;
import Cicerone.controllers.ControllerGestisciPercorso;
import Cicerone.db.DB_Controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
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