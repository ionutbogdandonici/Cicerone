package Cicerone.interfaces;

/**
 * Interfaccia per rappresentare un'area
 */
public interface I_Area {
    
    int getID();

    String getToponimo(int ID_Area);

    boolean addToponimo(String toponimo);

    boolean setToponimo(int ID_Area, String newToponimo);

    int getTerritorio(String toponimo);
}
