package Cicerone.controllers;

import Cicerone.classes.Tappa;
import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciTappa implements I_ControllerGestisciTappa {

    private Set<Tappa> tappe = new HashSet<>();

    ControllerGestisciArea controllerGestisciArea = new ControllerGestisciArea();


    @Override
    public boolean insertInDb(String nome, String descrizione, String raggiunta, String toponimo) throws SQLException {
        String ID_AREA = controllerGestisciArea.getByToponimo(toponimo).getID();
        if (checkDB(nome, ID_AREA)) {
            DB_Controller.insertQuery("INSERT INTO tappa (Nome, Descrizione, Raggiunta, ID_AREA) VALUES ('" + nome + "', '" + descrizione + "','" + raggiunta + "','" + raggiunta + "','" + ID_AREA + "')");
            refreshData();
            return true;
        }
        return false;
    }

    @Override
    public Tappa getTappaByName(String name) {
        return null;
    }

    @Override
    public Tappa getTappaById(int ID) {
        return null;
    }

    @Override
    public Set<Tappa> getAllTappeByArea(I_Area area) {
        return null;
    }

    @Override
    public boolean removeTappaFromDB(String nome) throws SQLException {
        Tappa toRemove = getTappaByName(nome);
        if (!checkDB(toRemove.getNome(), toRemove.getArea().getID())) {
            String query = "REMOVE FROM tappa WHERE Nome = \'" + nome + "\' AND ID_AREA=\'" +
                    toRemove.getArea().getID() + "\'";
            DB_Controller.removeQuery(query);
            refreshData();
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "ControllerGestisciTappa{" +
                "tappe=" + tappe +
                '}';
    }

    private void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("tappa");
        while (resultSet.next()) {
            tappe.add(new Tappa(
                    resultSet.getString("ID_TAPPA"),
                    resultSet.getString("Nome"),
                    resultSet.getString("Descrizione"),
                    resultSet.getString("Raggiunta"),
                    resultSet.getString("ID_AREA")));
        }
    }

    public boolean checkDB(String nome, String ID_AREA) throws SQLException {
        String query = "SELECT Nome, ID_AREA FROM tappa WHERE Nome=\"" + nome + "\" AND ID_AREA=\"" + ID_AREA + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }
}
