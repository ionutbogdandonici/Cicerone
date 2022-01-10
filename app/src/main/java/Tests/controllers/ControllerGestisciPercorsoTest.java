package Tests.controllers;

import Cicerone.classes.Percorso;
import Cicerone.controllers.ControllerGestisciPercorso;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerGestisciPercorsoTest {

    @Test
    void insertDB() throws SQLException {
        Percorso daInserire = new Percorso("134", "Giovedi sera serata!");
        ControllerGestisciPercorso controllerGestisciPercorso = new ControllerGestisciPercorso();
        controllerGestisciPercorso.insertDB(daInserire);
    }

    @Test
    void getAllData() {
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