package Cicerone.controllers;

import Cicerone.classes.Esperienza;

import java.sql.SQLException;
import java.util.Set;

public class ControllerGestisciEsperienza implements I_ControllerGenericoGestioneDB<Esperienza> {


    @Override
    public boolean insertDB(Esperienza element) throws SQLException {
        return false;
    }

    @Override
    public Set<Esperienza> getAllData() throws SQLException {
        return null;
    }

    @Override
    public Esperienza getById(String id) throws SQLException {
        return null;
    }

    @Override
    public Esperienza getByName(String nome) throws SQLException {
        return null;
    }

    @Override
    public void refreshData() throws SQLException {

    }

    @Override
    public boolean checkDB(Esperienza element) {
        return false;
    }
}
