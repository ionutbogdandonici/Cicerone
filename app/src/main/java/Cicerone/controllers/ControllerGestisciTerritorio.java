package Cicerone.controllers;

import Cicerone.db.DB_Controller;

import java.sql.SQLException;

public class ControllerGestisciTerritorio implements I_ControllerGestisciTerritorio{
    @Override
    public boolean insertInDB(String nome, String regione) throws SQLException {
        return checkDB(nome, regione);
    }

    private boolean checkDB(String nome, String regione) throws SQLException {
        return DB_Controller.ifExistQuery("SELECT Nome, ID_REGIONE FROM territorio" +
                "WHERE Nome= \""+nome+"\" AND ID_REGIONE=\""+regione+"\"");
    }
}
