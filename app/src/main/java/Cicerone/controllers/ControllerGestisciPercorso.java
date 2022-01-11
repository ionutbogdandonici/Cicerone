package Cicerone.controllers;

import Cicerone.classes.Percorso;
import Cicerone.classes.Tappa;
import Cicerone.db.DB_Controller;
import Cicerone.interfaces.I_Tappa;
import org.checkerframework.checker.units.qual.A;

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
        if (element.getTappe() == null) {
            insertPercorsoBase(element);
        } else {
            insertPercorsoCompleto(element);
        }

        return true;
    }

    private void insertPercorsoBase(Percorso element) throws SQLException {
        String query = "INSERT INTO percorso (Nome, Descrizione) VALUES('" + element.getName() + "','" + element.getDescrizione() + "')";
        DB_Controller.insertQuery(query);
        refreshData();
    }

    private void insertPercorsoCompleto(Percorso element) throws SQLException {
        // Inserimento tabella 'percorso'
        String query = "INSERT INTO percorso (Nome, Descrizione) VALUES('" + element.getName() + "','" + element.getDescrizione() + "')";
        // Inserimento tabella 'percorso_tappa' - 'tappa'
        Percorso conID = getByName(element.getName());
        ControllerGestisciTappa controllerTappa = new ControllerGestisciTappa();
        for (Tappa tappa : element.getTappe()) {
            controllerTappa.insertDB(tappa);
            System.out.println("ID Percorso: " + conID.getId());
            System.out.println("ID Tappa: " + tappa.getId());

            String queryPT = "INSERT INTO percorso_tappa (ID_PERCORSO, ID_TAPPA) " +
                    "VALUES ('" + conID.getId() + "','" + tappa.getId() + "')";
            DB_Controller.insertQuery(queryPT);
        }
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
