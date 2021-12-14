package Cicerone.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface I_ControllerGestisciTerritorio {

    /**
     * Metodo che permette l'inserimento di un territorio nel DB
     * @param nome del territorio
     * @param regione del territorio
     * @return <code>true</code> se il territorio &egrave; stato inserito correttamente
     * nel DB, <code>false</code> altrimenti
     */
    boolean insertInDB(String nome, String regione) throws SQLException;

    HashMap<Integer,ArrayList<String>> getFetchedData() throws SQLException;

    HashMap<Integer, ArrayList<String>> getById(int id);

    HashMap<Integer, ArrayList<String>> getByName(String nome);

    void gui() throws SQLException;
}
