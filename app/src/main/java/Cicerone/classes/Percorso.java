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
    private Territorio territorio;
    private ArrayList<Tappa> tappe = new ArrayList<>();
    private ArrayList<Area> aree;

    // Costruttore utile per la creazione di un percorso
    public Percorso(String nome, String descrizione) {
        this.Nome = nome;
        this.Descrizione = descrizione;
    }

    // Costruttore per l'istanziamento dei campi del DB
    public Percorso(String ID_Percorso, String nome, String descrizione) {
        this.ID_Percorso = ID_Percorso;
        this.Nome = nome;
        this.Descrizione = descrizione;
    }

    // Costruttore utile per l'assegnazione delle tappe ed aree
    public Percorso(String ID_Percorso, String nome, String descrizione, Territorio territorio, ArrayList<Tappa> tappe, ArrayList<Area> aree) {
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
    public ArrayList<Tappa> getTappe() {
        return this.tappe;
    }

    @Override
    public void addTappa(Tappa tappa) {
        if (tappa == null)
            throw new NullPointerException("Parametro nullo");
        tappe.add(tappa);
    }

    @Override
    public ArrayList<Area> getAree() {
        return this.aree;
    }

    @Override
    public void addArea(Area area) {
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
    public Territorio getTerritorio() {
        return this.territorio;
    }

    @Override
    public void setTerritorio(Territorio territorio) {
        if (territorio == null)
            throw new NullPointerException("Parametro nullo");
        this.territorio = territorio;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getDescrizione();
    }
}
