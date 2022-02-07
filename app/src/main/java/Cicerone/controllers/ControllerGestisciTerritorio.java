package Cicerone.controllers;

import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;
import Cicerone.interfaces.I_ControllerGenericoGestioneDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ControllerGestisciTerritorio implements I_ControllerGenericoGestioneDB<Territorio> {

    private Set<Territorio> territori = new HashSet<>();


    @Override
    public boolean insertDB(Territorio element) throws SQLException {
        if (checkDB(element)) {
            DB_Controller.insertQuery("INSERT INTO territorio (Nome, ID_REGIONE) VALUES ('" + element.getNome() + "', '" + element.getIDRegione() + "')");
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
    public String toString() {
        return "territori=" + territori;
    }

    @Override
    public void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("territorio");
        while (resultSet.next()) {
            territori.add(new Territorio(
                    resultSet.getString("ID_TERRITORIO"),
                    resultSet.getString("Nome"),
                    resultSet.getString("ID_REGIONE")));
        }
    }

    @Override
    public boolean checkDB(Territorio element) {
        String query = "SELECT Nome, ID_REGIONE FROM territorio WHERE Nome=\"" + element.getNome() + "\" AND ID_REGIONE=\"" + element.getIDRegione() + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }



}
