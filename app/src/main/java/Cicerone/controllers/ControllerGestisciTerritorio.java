package Cicerone.controllers;

import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ControllerGestisciTerritorio implements I_ControllerGestisciTerritorio {

    private Set<Territorio> territori = new HashSet<>();


    @Override
    public boolean insertInDB(String nome, String regione) throws SQLException {
        if (checkDB(nome, regione)) {
            DB_Controller.insertQuery("INSERT INTO territorio (Nome, ID_REGIONE) VALUES ('" + nome + "', '" + regione + "')");
            return true;
        }
        return false;

    }

    @Override
    public void getAllData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("territorio");
        while (resultSet.next()) {
            territori.add(new Territorio(
                    resultSet.getString("ID_TERRITORIO"),
                    resultSet.getString("Nome"),
                    resultSet.getString("ID_REGIONE")));
        }
    }

    @Override
    public Territorio getById(String id) throws SQLException {
        getAllData();
        for (Territorio territorio : territori) {
            if (territorio.getID().equals(id))
                return territorio;
        }
        return null;
    }

    @Override
    public Territorio getByName(String nome) throws SQLException {
        getAllData();
        for (Territorio territorio : territori) {
            if (territorio.getNome().equals(nome))
                return territorio;
        }
        return null;
    }


    @Override
    public void gui() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il nome del territorio: ");
        String nome = in.nextLine();
        System.out.println("Inserisci il nome della regione: ");
        String regione = in.nextLine();
        if (insertInDB(nome, regione)) {
            System.out.println("Inserimento con successo!");
        } else {
            System.out.println("Valore preesistente!");
        }
    }

    private boolean checkDB(String nome, String regione) throws SQLException {
        String query = "SELECT Nome, ID_REGIONE FROM territorio WHERE Nome=\"" + nome + "\" AND ID_REGIONE=\"" + regione + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;

    }

    @Override
    public String toString() {
        return "territori=" + territori;
    }
}
