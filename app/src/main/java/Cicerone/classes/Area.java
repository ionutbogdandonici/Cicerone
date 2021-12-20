package Cicerone.classes;

import Cicerone.interfaces.I_Area;

public class Area implements I_Area {

    private String ID_Area;
    private String Toponimo;
    private String ID_Territorio;

    public Area(String ID_Area, String toponimo, String ID_Territorio) {
        this.ID_Area = ID_Area;
        Toponimo = toponimo;
        this.ID_Territorio = ID_Territorio;
    }


    @Override
    public String getID() {
        return this.ID_Area;
    }

    @Override
    public String getToponimo(String ID_Area) {
       return null;
    }

    @Override
    public boolean addToponimo(String toponimo) {
        return false;
    }

    @Override
    public boolean setToponimo(String ID_Area, String newToponimo) {
        return false;
    }

    @Override
    public int getTerritorio(String toponimo) {
        return 0;
    }


}
