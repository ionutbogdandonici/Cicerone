package Cicerone.controllers;

import Cicerone.classes.Territorio;

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

    /**
     * Ritorna i dati all'interno della tabella territorio
     *
     * @return dati tabella
     * @throws SQLException problemi di query
     */
    ArrayList<Territorio> getFetchedData() throws SQLException;

    ArrayList<Territorio> getById(int id);

    ArrayList<Territorio> getByName(String nome);

    void gui() throws SQLException;
}
