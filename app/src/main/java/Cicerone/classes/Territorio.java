package Cicerone.classes;

import Cicerone.interfaces.I_Territorio;

import java.util.Objects;

public class Territorio implements I_Territorio {

    private  String ID;
    private final String nome;
    private final String id_Regione;

    public Territorio(String ID, String nome, String id_Regione) {
        // TODO gestione degli errori
        this.ID = ID;
        this.nome = nome;
        this.id_Regione = id_Regione;
    }

    public Territorio(String nome, String id_Regione) {
        // TODO gestione degli errori

        this.nome = nome;
        this.id_Regione = id_Regione;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getIDRegione() {
        return id_Regione;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Territorio that = (Territorio) o;
        return ID.equals(that.ID) && nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nome);
    }

    @Override
    public String toString() {
        return "Territorio{" +
                "ID='" + ID + '\'' +
                ", nome='" + nome + '\'' +
                ", id_Regione='" + id_Regione + '\'' +
                '}';
    }
}
