package Cicerone.interfaces;

/**
 * Interfaccia per rappresentare un territorio
 */
public interface I_Territorio {

    String getID();

    String getNome(int ID);

    boolean setNome(String nome);

    String getRegione(int ID);

}
