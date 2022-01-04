package Cicerone.controllers;

import java.util.Set;

public interface I_ControllerGenereicoGestioneDB<E> {

    /**
     * Operazione che permette l'inserimento dei dati all'interno di un DB
     *
     * @param values parametri da inserire
     * @return <code>true</code> se l'operazione è andata a buon fine, <code>false</code> altrimenti
     */
    boolean insertDB(String... values);

    /**
     * Operazione che ci ritorna tutti i dati all'interno del DB
     *
     * @return tutti i dati di una determinata tabella del DB in un Set
     */
    Set<E> getAllData();

    /**
     * Ritorna un determinato elemento di una tabella in base all'ID
     *
     * @param id dell'elemento interessato
     * @return l'elemento interessato, altrimenti <code>null</code>
     */
    E getById(String id);

    /**
     * Aggiorna i dati all'interno del
     */
    void refreshData();

    /**
     * Controlla la presenza di un determinata istanza all'interno del DB
     *
     * @param values parametri dell'istanza
     * @return <code>true</code> se l'istanza vi è stato trovata, <code>false</code> altrimenti
     */
    boolean checkDB(String... values);

}
