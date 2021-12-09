package Cicerone.controllers;

import Cicerone.db.DB_Controller;

import java.sql.SQLException;

public class ControllerGestisciTerritorio implements I_ControllerGestisciTerritorio{
    @Override
    public boolean insertInDB(String nome, String regione) throws SQLException {
        if(checkDB(nome,regione)){
             DB_Controller.insertQuery("INSERT INTO territorio (Nome, ID_REGIONE) VALUES ('Fermo', 'Marche')");
             return true;
        }
        return false;

    }

    private boolean checkDB(String nome, String regione) throws SQLException {
        return DB_Controller.ifExistQuery("SELECT Nome, ID_REGIONE FROM territorio " +
                "WHERE Nome=\""+nome+"\" AND ID_REGIONE=\""+regione+"\"");
    }
}
