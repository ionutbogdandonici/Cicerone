package Cicerone.controllers;

import Cicerone.classes.Tappa;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

import java.util.Set;

public interface I_ControllerGestisciTappa {

    void insertInDb(String nome, String descrizione, String raggiunta, I_Area area);

    Tappa getTappaByName(String name);

    Tappa getTappaById(int ID);

    String getRaggiunta(String nome);

    String getDescrizione(String nome);

    Set<Tappa> getAllTappeByArea(I_Area area);

    void removeTappaFromDB(int ID);
}
