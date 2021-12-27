package Cicerone.classes;

import Cicerone.interfaces.I_Area;

public class Area implements I_Area {

    private String ID_Area;
    private String Toponimo;
    private String ID_Territorio;

    public Area(String ID_Area, String toponimo, String ID_Territorio) {
        this.ID_Area = ID_Area;
        this.Toponimo = toponimo;
        this.ID_Territorio = ID_Territorio;
    }

    @Override
    public String getID() {
        return this.ID_Area;
    }

    @Override
    public String getToponimo() {
       return this.Toponimo;
    }

    @Override
    public String getTerritorio() {
        return ID_Territorio;
    }

    @Override
    public String toString() {
        return "Area{" +
                "ID_Area='" + ID_Area + '\'' +
                ", Toponimo='" + Toponimo + '\'' +
                ", ID_Territorio='" + ID_Territorio + '\'' +
                '}';
    }
}
