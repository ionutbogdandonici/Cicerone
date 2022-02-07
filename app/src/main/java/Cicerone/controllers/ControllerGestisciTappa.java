package Cicerone.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Tappa;
import Cicerone.db.DB_Controller;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_ControllerGenericoGestioneDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciTappa implements I_ControllerGenericoGestioneDB<Tappa> {

    private Set<Tappa> tappe = new HashSet<>();

    ControllerGestisciArea controllerGestisciArea = new ControllerGestisciArea();


    @Override
    public boolean insertDB(Tappa element) throws SQLException {
        String ID_AREA = element.getArea().getID();
        if (checkDB(element)) {
            String query = "INSERT INTO tappa (Nome, Descrizione, Raggiunta, ID_AREA) VALUES (\'" + element.getNome() + "\', \'" + element.getDescrizione() + "\',\'" + element.getRaggiunta() + "\',\'" + ID_AREA + "\')";
            DB_Controller.insertQuery(query);
            refreshData();
            return true;
        }
        return false;
    }


    public Set<Tappa> getAllTappeByArea(I_Area area) {
        return null;
    }

    @Override
    public String toString() {
        return "ControllerGestisciTappa{" +
                "tappe=" + tappe +
                '}';
    }

    @Override
    public Set<Tappa> getAllData() throws SQLException {
        return this.tappe;
    }

    @Override
    public Tappa getById(String id) throws SQLException {
        refreshData();
        for (Tappa tappa : tappe) {
            if (tappa.getId().equals(id))
                return tappa;
        }
        return null;
    }

    @Override
    public Tappa getByName(String nome) throws SQLException {
        return null;
    }

    @Override
    public void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("tappa");
        while (resultSet.next()) {
            ControllerGestisciArea con = new ControllerGestisciArea();
            Area daAggiungere = con.getById(resultSet.getString("ID_AREA"));
            tappe.add(new Tappa(
                    resultSet.getString("ID_TAPPA"),
                    resultSet.getString("Nome"),
                    resultSet.getString("Descrizione"),
                    resultSet.getString("Raggiunta"),
                    daAggiungere));
        }
    }

    @Override
    public boolean checkDB(Tappa element) {
        String query = "SELECT Nome, ID_AREA FROM tappa WHERE Nome=\"" + element.getNome() + "\" AND ID_AREA=\"" + element.getArea() + "\"";
        return DB_Controller.getNumberRows(query) == 0;
    }

}
