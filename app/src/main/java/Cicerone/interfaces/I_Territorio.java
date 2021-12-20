package Cicerone.interfaces;

/**
 * Interfaccia per rappresentare un territorio
 */
public interface I_Territorio {

    /**
     * Ritorna l'ID del territorio
     * @return ID
     */
    String getID();

    /**
     *
     * @param ID
     * @return
     */
    String getNome(int ID);

    String getIDRegione(int ID);

}
