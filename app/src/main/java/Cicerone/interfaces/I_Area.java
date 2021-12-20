package Cicerone.interfaces;

/**
 * Interfaccia per rappresentare un'area
 */
public interface I_Area {

    String getID();

    String getToponimo(String ID_Area);

    int getTerritorio(String toponimo);
}
