package Cicerone.classes;

import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Percorso;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ProcessorErrorHandler;

import java.util.ArrayList;

public class Percorso implements I_Percorso {

    private String ID_Percorso;
    private String Nome;
    private String Descrizione;
    private I_Territorio territorio;
    private ArrayList<I_Tappa> tappe;
    private ArrayList<I_Area> aree;

    public Percorso(String nome, String descrizione) {
        this.Nome = nome;
        this.Descrizione = descrizione;
    }

    public Percorso(String ID_Percorso, String nome, String descrizione) {
        this.ID_Percorso = ID_Percorso;
        this.Nome = nome;
        this.Descrizione = descrizione;
    }

    public Percorso(String ID_Percorso, String nome, String descrizione, I_Territorio territorio, ArrayList<I_Tappa> tappe, ArrayList<I_Area> aree) {
        if (nome == null || descrizione == null || territorio == null) {
            throw new NullPointerException("Inserisci tutti i parametri");
        }
        this.ID_Percorso = ID_Percorso;
        this.Nome = nome;
        this.Descrizione = descrizione;
        this.territorio = territorio;
        this.tappe = tappe;
        this.aree = aree;
    }

    @Override
    public String getId() {
        return this.ID_Percorso;
    }

    @Override
    public ArrayList<I_Tappa> getTappe() {
        return this.tappe;
    }

    @Override
    public void addTappa(I_Tappa tappa) {
        if (tappa == null)
            throw new NullPointerException("Parametro nullo");
        tappe.add(tappa);

    }

    @Override
    public ArrayList<I_Area> getArea() {
        return this.aree;
    }

    @Override
    public void addArea(I_Area area) {
        if (area == null)
            throw new NullPointerException("Parametro nullo");
        aree.add(area);
    }

    @Override
    public String getName() {
        return this.Nome;
    }

    @Override
    public void setNome(String nome) {
        if (nome == null)
            throw new NullPointerException("Parametro nullo");
        this.Nome = nome;
    }

    @Override
    public String getDescrizione() {
        return this.Descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        if (descrizione == null)
            throw new NullPointerException("Parametro nullo");
        this.Descrizione = descrizione;
    }

    @Override
    public I_Territorio getTerritorio() {
        return this.territorio;
    }

    @Override
    public void setTerritorio(I_Territorio territorio) {
        if (territorio == null)
            throw new NullPointerException("Parametro nullo");
        this.territorio = territorio;
    }
}
