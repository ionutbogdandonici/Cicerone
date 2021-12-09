package Cicerone.controllers;

import Cicerone.classes.Tappa;
import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

public class ControllerGestisciTappa implements I_ControllerGestisciTappa{

    private Tappa tappa;

    @Override
    public void createTappa(String nome, String descrizione, String raggiunta, I_Area area, I_Territorio territorio) {
        tappa = new Tappa(nome, descrizione, raggiunta, area, territorio);
    }

    @Override
    public void addTappaToDB(I_Tappa tappa) {

    }

    @Override
    public void getTappaFromDB(String name) {

    }

    @Override
    public void getTappaFromDB(int ID) {

    }

    @Override
    public void updateTappaInDB() {

    }

    @Override
    public void removeTappaFromDB(int ID) {

    }
}
