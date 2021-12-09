package Cicerone.controllers;

import Cicerone.classes.Tappa;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

public interface I_ControllerGestisciTappa {

    void createTappa(String nome, String descrizione, String raggiunta, I_Area area, I_Territorio territorio);

    void addTappaToDB(I_Tappa tappa);

    void getTappaFromDB(String name);

    void getTappaFromDB(int ID);

    void updateTappaInDB();

    void removeTappaFromDB(int ID);
}
