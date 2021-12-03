package Cicerone.interfacce;

import java.util.ArrayList;

/**
 *  Interfaccia che rappresenta un percorso, esso &egrave; caratterizzato da un insieme di Tappe
 */
public interface I_Percorso{

    /**
     * Restituisce l'id del percorso
     * @return id percorso
     */
    int getId();

    /**
     * Restituisce tutte le tappe attraversate dal percorso
     * @return
     */
    ArrayList<I_Tappa> getTappe();

    /**
     * Inserisce una nuova tappa nella lista delle tappe
     * @param tappa
     */
    void addTappa(I_Tappa tappa);

    /**
     * Restotuisce tutte le aree attraverste dal percorso
     * @return ArrayList di aree
     */
    ArrayList<I_Area> getArea();

    /**
     * Inserisce una nuva area all'interno della lista aree
     * @param area
     */
    void addArea(I_Area area);

    /**
     * Ritorna il nome del percorso
     * @return nome
     */
    String getName();

    /**
     * Inserisce il nome per il percorso
     * @param nome
     */
    void setNome(String nome);

    /**
     * Restituisce la descrizione del percorso
     * @return descrizione percorso
     */
    String getDescrizione();

    /**
     * Permette di inserire una descrizione per il percorso
     * @param descrizione
     */
    void setDescrizione(String descrizione);


    /**
     * Ritorna il territorio dove il percorso passa
     * @return territorio
     */
    I_Territorio getTerritorio();

    /**
     * Permette di inserire un territorio
     * @param territorio
     */
    void setTerritorio(I_Territorio territorio);


}