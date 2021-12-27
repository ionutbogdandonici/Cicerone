package Cicerone.controllers;

import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ControllerGestisciTerritorio implements I_ControllerGestisciTerritorio {

    private Set<Territorio> territori = new HashSet<>();



    @Override
    public boolean insertInDB(String nome, String regione) throws SQLException {
        if (checkDB(nome, regione)) {
            DB_Controller.insertQuery("INSERT INTO territorio (Nome, ID_REGIONE) VALUES ('" + nome + "', '" + regione + "')");
            refreshData();
            return true;
        }
        return false;
    }

    @Override
    public Set<Territorio> getAllData() throws SQLException {
        return this.territori;
    }


    @Override
    public Territorio getById(String id) throws SQLException {
        refreshData();
        for (Territorio territorio : territori) {
            if (territorio.getID().equals(id))
                return territorio;
        }
        return null;
    }



    @Override
    public Territorio getByName(String nome) throws SQLException {
        refreshData();
        for (Territorio territorio : territori) {
            if (territorio.getNome().equals(nome))
                return territorio;
        }
        return null;
    }

    @Override
    public boolean removeTerritorioFromDB(String nome) {
        return false;
    }


    @Override
    public String toString() {
        return "territori=" + territori;
    }


    private void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("territorio");
        while (resultSet.next()) {
            territori.add(new Territorio(
                    resultSet.getString("ID_TERRITORIO"),
                    resultSet.getString("Nome"),
                    resultSet.getString("ID_REGIONE")));
        }
    }

    private boolean checkDB(String nome, String regione) throws SQLException {
        String query = "SELECT Nome, ID_REGIONE FROM territorio WHERE Nome=\"" + nome + "\" AND ID_REGIONE=\"" + regione + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }


}
