package Cicerone.controllers;

import Cicerone.classes.Territorio;

import java.sql.SQLException;
import java.util.Set;

public interface I_ControllerGestisciTerritorio {

    /**
     * Metodo che permette l'inserimento di un territorio nel DB
     *
     * @param nome    del territorio
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
    Set<Territorio> getAllData() throws SQLException;

    Territorio getById(String id) throws SQLException;

    Territorio getByName(String nome) throws SQLException;

    boolean removeTerritorioFromDB(String nome);
}
