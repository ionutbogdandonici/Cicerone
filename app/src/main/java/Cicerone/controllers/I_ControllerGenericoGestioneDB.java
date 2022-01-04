package Cicerone.controllers;

import java.sql.SQLException;
import java.util.Set;

public interface I_ControllerGenericoGestioneDB<E> {

    /**
     * Operazione che permette l'inserimento dei dati all'interno di un DB
     *
     * @param element parametri da inserire
     * @return <code>true</code> se l'operazione è andata a buon fine, <code>false</code> altrimenti
     */
    boolean insertDB(E element) throws SQLException;

    /**
     * Operazione che ci ritorna tutti i dati all'interno del DB
     *
     * @return tutti i dati di una determinata tabella del DB in un Set
     */
    Set<E> getAllData() throws SQLException;

    /**
     * Ritorna un determinato elemento di una tabella in base all'ID
     *
     * @param id dell'elemento interessato
     * @return l'elemento interessato, altrimenti <code>null</code>
     */
    E getById(String id) throws SQLException;

    /**
     * Ritorna un determinato elemento di una tabella in base al Nome
     * @param nome dell'elemento interessato
     * @return l'elemento interessato, altrimenti <code>null</code>
     * @throws SQLException
     */
    E getByName(String nome) throws SQLException;

    /**
     * Aggiorna i dati all'interno del
     */
    void refreshData() throws SQLException;

    /**
     * Controlla la presenza di un determinata istanza all'interno del DB
     *
     * @param element parametri dell'istanza
     * @return <code>true</code> se l'istanza vi è stato trovata, <code>false</code> altrimenti
     */
    boolean checkDB(E element);

}
