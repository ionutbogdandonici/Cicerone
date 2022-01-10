package Cicerone.controllers;

import Cicerone.classes.Esperienza;
import Cicerone.classes.Percorso;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciEsperienza implements I_ControllerGenericoGestioneDB<Esperienza> {

    private final Set<Esperienza> esperienze = new HashSet<>();

    @Override
    public boolean insertDB(Esperienza element) throws SQLException {
        if (element == null)
            throw new NullPointerException("Parametro null!");
        if (checkDB(element))
            return false;
        String query = "INSERT INTO esperienza (DataEsperienza, Nome, Descrizione, Costo, PostiMax, PostiMin, PostiRiservati, PostiInSospeso, GiorniRiservatezzaPosti) VALUES('" + element.getDataEsperienza() + "','" + element.getNome() + "','" + element.getDescrizione() + "','" +
                element.getCosto() + "','" + element.getPostiMax() + "','" + element.getPostiMin() + "','" + element.getPostiRiservati() + "','" + element.getPostiInSospeso() + "','" + element.getGiorniRiservatezzaPosti() + "')";
        DB_Controller.insertQuery(query);
        refreshData();
        return true;
    }

    @Override
    public Set<Esperienza> getAllData() throws SQLException {
        return this.esperienze;
    }

    @Override
    public Esperienza getById(String id) throws SQLException {
        refreshData();
        for (Esperienza esperienza : esperienze) {
            if (esperienza.getId().equals(id))
                return esperienza;
        }
        return null;
    }

    @Override
    public Esperienza getByName(String nome) throws SQLException {
        refreshData();
        for (Esperienza esperienza : esperienze) {
            if (esperienza.getNome().equals(nome))
                return esperienza;
        }
        return null;
    }

    @Override
    public void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("esperienza");
        while (resultSet.next()) {
            esperienze.add(new Esperienza(
                    resultSet.getString("ID_ESPERIENZA"),
                    resultSet.getDate("DataEsperienza").toLocalDate(),
                    resultSet.getString("Nome"),
                    resultSet.getString("Descrizione"),
                    resultSet.getFloat("Costo"),
                    resultSet.getString("PostiMax"),
                    resultSet.getString("PostiMin"),
                    resultSet.getString("PostiRiservati"),
                    resultSet.getString("PostiInSospeso"),
                    resultSet.getString("GiorniRiservatezzaPosti")));
        }
    }

    @Override
    public boolean checkDB(Esperienza element) {
        return false;
    }
}
