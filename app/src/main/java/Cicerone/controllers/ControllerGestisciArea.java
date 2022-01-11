package Cicerone.controllers;

import Cicerone.classes.Area;
import Cicerone.classes.Territorio;
import Cicerone.db.DB_Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ControllerGestisciArea implements I_ControllerGenericoGestioneDB<Area> {

    private Territorio territorioArea;
    private final Set<Area> aree = new HashSet<>();
    ControllerGestisciTerritorio controllerGestisciTerritorio = new ControllerGestisciTerritorio();
    

    @Override
    public boolean insertDB(Area element) throws SQLException {
        String ID_Territorio = controllerGestisciTerritorio.getByName(element.getTerritorio()).getID();
        //TODO CONTROLLO ERRORI
        if (checkDB(element)) {
            DB_Controller.insertQuery("INSERT INTO area (Toponimo, ID_TERRITORIO) VALUES ('" + element.getToponimo() + "', '" + ID_Territorio + "')");
            refreshData();
            return true;
        }
        return false;
    }

    @Override
    public void refreshData() throws SQLException {
        ResultSet resultSet = DB_Controller.selectAllFromTable("area");
        while (resultSet.next()) {
            aree.add(new Area(
                    resultSet.getString("ID_AREA"),
                    resultSet.getString("Toponimo"),
                    resultSet.getString("ID_TERRITORIO")));
        }
    }

    @Override
    public boolean checkDB(Area element) {
        String query = "SELECT ID_AREA, Toponimo, ID_TERRITORIO FROM area WHERE Toponimo =\"" + element.getToponimo() + "\" AND ID_TERRITORIO=\"" + element.getTerritorio()+ "\"";
        System.out.println(DB_Controller.getNumberRows(query));
        return DB_Controller.getNumberRows(query) == 0;
    }


    @Override
    public Set<Area> getAllData() throws SQLException {
        return this.aree;
    }

    @Override
    public Area getById(String ID_Area) throws SQLException {
        refreshData();
        for (Area area : aree) {
            if (area.getID().equals(ID_Area))
                return area;
        }
        return null;
    }

    @Override
    public Area getByName(String nome) throws SQLException {
        refreshData();
        for (Area area : aree) {
            if (area.getToponimo().equals(nome))
                return area;
        }
        return null;
    }


    public Set<Area> getAllByTerritorio(String ID_Territorio) {
        return null;
    }


    public Territorio getTerritorioByToponimo(String toponimo) {
        return null;
    }


    @Override
    public String toString() {
        return "ControllerGestisciArea{" +
                "aree=" + aree +
                '}';
    }
}
