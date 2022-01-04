package Cicerone.controllers;

import Cicerone.classes.Percorso;
import Cicerone.db.DB_Controller;

import java.sql.SQLException;
import java.util.Set;

public class ControllerGestisciPercorso implements I_ControllerGenericoGestioneDB<Percorso> {


    @Override
    public boolean insertDB(Percorso element) throws SQLException {
        return false;
    }

    @Override
    public Set<Percorso> getAllData() throws SQLException {
        return null;
    }

    @Override
    public Percorso getById(String id) throws SQLException {
        return null;
    }

    @Override
    public Percorso getByName(String nome) throws SQLException {
        return null;
    }

    @Override
    public void refreshData() throws SQLException {

    }

    @Override
    public boolean checkDB(Percorso element) {
        return false;
    }
}
