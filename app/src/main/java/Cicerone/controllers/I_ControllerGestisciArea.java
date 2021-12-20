package Cicerone.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Territorio;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public interface I_ControllerGestisciArea {

    boolean insertInDB(String Toponoimo, String NomeTerritorio) throws SQLException;

    void refreshData() throws SQLException;

    Area getById(String ID_Area) throws SQLException;

    Area getByToponimo(String Toponimo) throws SQLException;

    Set<Area> getAllByTerritorio(String ID_Territorio);

    Territorio getTerritorioByToponimo(String toponimo);


}
