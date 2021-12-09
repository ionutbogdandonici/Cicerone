package Cicerone.classes;

import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Percorso;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

import java.util.ArrayList;

public class Percorso implements I_Percorso {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public ArrayList<I_Tappa> getTappe() {
        return null;
    }

    @Override
    public void addTappa(I_Tappa tappa) {

    }

    @Override
    public ArrayList<I_Area> getArea() {
        return null;
    }

    @Override
    public void addArea(I_Area area) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setNome(String nome) {

    }

    @Override
    public String getDescrizione() {
        return null;
    }

    @Override
    public void setDescrizione(String descrizione) {

    }

    @Override
    public I_Territorio getTerritorio() {
        return null;
    }

    @Override
    public void setTerritorio(I_Territorio territorio) {

    }
}
