package Cicerone.interfaces;

/**
 * Interfaccia per rappresentare un'area
 */
public interface I_Area {
    
    String getID();

    String getToponimo(String ID_Area);

    boolean addToponimo(String toponimo);

    boolean setToponimo(String ID_Area, String newToponimo);

    int getTerritorio(String toponimo);
}
