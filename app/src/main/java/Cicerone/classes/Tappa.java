package Cicerone.classes;

import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

public class Tappa implements I_Tappa {

    private int ID_Tappa;
    private String nome;
    private String descrizione;
    private String raggiunta;
    private I_Area area;



    @Override
    public int getId() {
        return 0;
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
    public String getRaggiunta() {
        return null;
    }

    @Override
    public void setRaggiunta(String raggiunta) {

    }

    @Override
    public I_Area getArea() {
        return null;
    }

    @Override
    public void setArea(I_Area area) {

    }

    @Override
    public I_Territorio getTerritorio() {
        return null;
    }

    @Override
    public void setTerritorio(I_Territorio territorio) {

    }
}
