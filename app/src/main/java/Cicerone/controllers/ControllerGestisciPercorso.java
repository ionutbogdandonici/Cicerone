package Cicerone.controllers;

import Cicerone.classes.Percorso;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciPercorso implements I_ControllerGenericoGestioneDB<Percorso> {

    private final Set<Percorso> percorsi = new HashSet<>();

    @Override
    public boolean insertDB(Percorso element) throws SQLException {
        if (element == null)
            throw new NullPointerException("Parametro null!");
        if (!checkDB(element))
            return false;

        String query = "INSERT INTO percorso (Nome, Descrizione) VALUES('" + element.getName() + "','" + element.getDescrizione() + "')";
        // TODO -> ASSOCIARE IL PERCORSO AD UNA TAPPA
        DB_Controller.insertQuery(query);
        refreshData();
        return true;
    }

    @Override
    public Set<Percorso> getAllData() throws SQLException {
        refreshData();
        return this.percorsi;
    }

    @Override
    public Percorso getById(String id) throws SQLException {
        refreshData();
        for (Percorso percorso : percorsi) {
            if (percorso.getId().equals(id))
                return percorso;
        }
        return null;
    }

    @Override
    public Percorso getByName(String nome) throws SQLException {
        refreshData();
        for (Percorso percorso : percorsi) {
            if (percorso.getName().equals(nome))
                return percorso;
        }
        return null;
    }

    @Override
    public void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("percorso");
        while (resultSet.next()) {
            percorsi.add(new Percorso(
                    resultSet.getString("ID_PERCORSO"),
                    resultSet.getString("Nome"),
                    resultSet.getString("Descrizione")));
        }
    }

    @Override
    public boolean checkDB(Percorso element) {
        String query = "SELECT Nome, Descrizione FROM percorso WHERE Nome =\"" + element.getName() + "\" AND Descrizione=\"" + element.getDescrizione() + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }
}
