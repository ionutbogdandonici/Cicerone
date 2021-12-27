package Cicerone.classes;

import Cicerone.interfaces.I_Area;
import Cicerone.interfaces.I_Tappa;
import Cicerone.interfaces.I_Territorio;

public class Tappa implements I_Tappa {


    private String nome;
    private String descrizione;
    private String raggiunta;
    private I_Area area;
    private I_Territorio territorio;

    /**
     * Costruttore di Tappa
     */
    public Tappa(
                  String ID_TAPPA,
                  String nome,
                  String descrizione,
                  String raggiunta,
                  String ID_AREA
    ){
        // Se uno o più parametri sono null
        if ( nome == null || descrizione == null || raggiunta == null || area == null)
            throw new NullPointerException("Parametri null!");

        this.nome=nome;
        this.descrizione=descrizione;
        this.raggiunta=raggiunta;
        this.area=area;

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        if (nome == null)
            throw new NullPointerException("Parametro null!");
        this.nome = nome;

    }

    @Override
    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        if (descrizione == null)
            throw new NullPointerException("Parametro null!");
        this.descrizione = descrizione;

    }

    @Override
    public String getRaggiunta() {
        return raggiunta;
    }

    @Override
    public void setRaggiunta(String raggiunta) {
        if(raggiunta == null)
            throw new NullPointerException("Parametro null!");
        this.raggiunta = raggiunta;

    }

    @Override
    public I_Area getArea() {
        return area;
    }

    @Override
    public void setArea(I_Area area) {
        if(area == null)
            throw new NullPointerException("Parametro null!");
        this.area=area;

    }

    @Override
    public I_Territorio getTerritorio() {
        return territorio;
    }

    @Override
    public void setTerritorio(I_Territorio territorio) {
        if(territorio == null)
            throw new NullPointerException("Parametro null!");
        this.territorio = territorio;

    }
}
