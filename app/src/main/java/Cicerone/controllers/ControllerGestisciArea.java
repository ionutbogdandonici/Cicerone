package Cicerone.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciArea implements I_ControllerGestisciArea {

    private Territorio territorioArea;
    private Set<Area> aree = new HashSet<>();
    ControllerGestisciTerritorio controllerGestisciTerritorio = new ControllerGestisciTerritorio();

    @Override
    public boolean insertInDB(String toponoimo, String NomeTerritorio) throws SQLException {
        String ID_Territorio = controllerGestisciTerritorio.getByName(NomeTerritorio).getID();
        //TODO CONTROLLO ERRORI
        if (checkDB(toponoimo, ID_Territorio)) {
            DB_Controller.insertQuery("INSERT INTO area (Toponimo, ID_TERRITORIO) VALUES ('" + toponoimo + "', '" + ID_Territorio + "')");
            return true;
        }
        return false;
    }

    @Override
    public void getAllData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("area");
        while (resultSet.next()) {
            aree.add(new Area(
                    resultSet.getString("ID_AREA"),
                    resultSet.getString("Toponimo"),
                    resultSet.getString("ID_TERRITORIO")));
        }
    }

    @Override
    public Area getById(String ID_Area) throws SQLException {
        return null;
    }

    @Override
    public Area getByToponimo(String Toponimo) throws SQLException {
        return null;
    }

    @Override
    public Set<Area> getAllByTerritorio(String ID_Territorio) {
        return null;
    }

    @Override
    public Territorio getTerritorioByToponimo(String toponimo) {
        return null;
    }


    private boolean checkDB(String toponimo, String ID_TERRITORIO) throws SQLException {
        String query = "SELECT ID_AREA, Toponimo, ID_TERRITORIO FROM area WHERE Toponimo =\"" + toponimo + "\" AND ID_TERRITORIO=\"" + ID_TERRITORIO + "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }


}
