package Cicerone.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Tappa;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

import java.sql.SQLException;
import java.util.Set;

public interface I_ControllerGestisciTappa {

    boolean insertInDb(String nome, String descrizione, String raggiunta, String toponimo) throws SQLException;

    Tappa getTappaByName(String name);

    Tappa getTappaById(int ID);

    Set<Tappa> getAllTappeByArea(I_Area area);

    boolean removeTappaFromDB(String nome) throws SQLException;
}
