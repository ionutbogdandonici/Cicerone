package Cicerone.classi;

import Cicerone.interfacce.I_Esperienza;
import Cicerone.interfacce.I_Percorso;
import Cicerone.interfacce.I_Tag;

import java.time.LocalDate;
import java.util.ArrayList;

public class Esperienza implements I_Esperienza {

    private LocalDate dataEsperienza;
    private String nome;
    private String descrizione;
    private I_Percorso percorso;
    private final ArrayList<I_Tag> tags;
    private float costo;
    private int postiMax;
    private int postiMin;
    private int postiRiservati;
    private int postiRiservatiMaNonConfermati;
    private LocalDate scadenzaPrenotazioni;
    private int giorniRiservatezzaPosti;

    Esperienza(LocalDate dataEsperienza,
               String nome,
               String descrizione,
               I_Percorso percorso,
               float costo,
               int postiMax,
               int postiMin,
               LocalDate scadenzaPrenotazioni,
               int giorniRiservatezzaPosti
    ) {
        // Gestione delle possibili eccezioni --- INIZIO
        // Se uno o più parametri sono null
        if (dataEsperienza == null || nome == null || descrizione == null || percorso == null || scadenzaPrenotazioni == null)
            throw new NullPointerException("Parametri null!");
        // Se la data inserita è antecedente al giorno d'oggi od è il giorno stesso
        if (dataEsperienza.isBefore(LocalDate.now()) || dataEsperienza.isEqual(LocalDate.now()))
            throw new IllegalArgumentException("L'esperienza non può essere fissata oggi od in una data passata!");
        if (scadenzaPrenotazioni.isBefore(LocalDate.now()) || scadenzaPrenotazioni.isEqual(LocalDate.now()))
            throw new IllegalArgumentException("L'esperienza non può essere fissata oggi od in una data passata!");
        // Se il costo, postiMin, postiMax è inferiore a 0
        if (costo < 0 || postiMin < 0 || postiMax < 0)
            throw new IllegalArgumentException("Parametri inferiori a 0");
        // Sei giorni di riservatezza sono minori o uguali a 2
        if (giorniRiservatezzaPosti < 2)
            throw new IllegalArgumentException("Giorni riservatezza inferiori a due");

        // Gestione delle possibili eccezioni --- FINE
        this.dataEsperienza = dataEsperienza;
        this.nome = nome;
        this.descrizione = descrizione;
        this.percorso = percorso;
        this.tags = new ArrayList<>();
        this.costo = costo;
        this.postiMax = postiMax;
        this.postiMin = postiMin;
        this.postiRiservati = 0;
        this.postiRiservatiMaNonConfermati = 0;
        this.scadenzaPrenotazioni = scadenzaPrenotazioni;
        this.giorniRiservatezzaPosti = giorniRiservatezzaPosti;
    }

    @Override
    public LocalDate getDataEsperienza() {
        return dataEsperienza;
    }

    @Override
    public void setDataEsperienza(LocalDate dataEsperienza) {
        if (dataEsperienza.isBefore(LocalDate.now()) || dataEsperienza.isEqual(LocalDate.now()))
            throw new IllegalArgumentException("L'esperienza non può essere fissata oggi od in una data passata!");

        this.dataEsperienza = dataEsperienza;
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
    public I_Percorso getPercorso() {
        return percorso;
    }

    @Override
    public void setPercorso(I_Percorso percorso) {
        if (percorso == null)
            throw new NullPointerException("Parametro null!");
        this.percorso = percorso;
    }

    @Override
    public ArrayList<I_Tag> getTags() {
        return tags;
    }

    @Override
    public void addTag(I_Tag tag) {
        if (tag == null)
            throw new NullPointerException("Parametro null!");
        tags.add(tag);
    }

    @Override
    public boolean removeTag(I_Tag tag) {
        if (tag == null)
            throw new NullPointerException("Parametro null!");
        return tags.remove(tag);
    }

    @Override
    public float getCosto() {
        return this.costo;
    }

    @Override
    public void setCosto(float costo) {
        if (costo < 0)
            throw new IllegalArgumentException("Il costo non può essere inferiore a 0!");
        this.costo = costo;
    }

    @Override
    public int getPostiMax() {
        return postiMax;
    }

    @Override
    public void setPostiMax(int postiMax) {
        if (postiMax < 0)
            throw new IllegalArgumentException("Parametro minore di 0");
        this.postiMax = postiMax;
    }

    @Override
    public int getPostiMin() {
        return postiMin;
    }

    @Override
    public void setPostiMin(int postiMin) {
        if (postiMin < 0)
            throw new IllegalArgumentException("Parametro minore di 0");
        this.postiMin = postiMin;
    }

    @Override
    public int getPostiRiservati() {
        return postiRiservati;
    }

    @Override
    public int incrementaPostiRiservati() {
        postiRiservati++;
        return postiRiservati;
    }

    @Override
    public int getPostiRiservatiMaNonConfermati() {
        return postiRiservatiMaNonConfermati;
    }

    @Override
    public int incrementaPostiRiservatiMaNonConfermati() {
        postiRiservatiMaNonConfermati++;
        return postiRiservatiMaNonConfermati;
    }

    @Override
    public LocalDate getScadenzaPrenotazioni() {
        return scadenzaPrenotazioni;
    }

    @Override
    public void setScadenzaPrenotazioni(LocalDate scadenzaPrenotazioni) {
        if (scadenzaPrenotazioni.isBefore(LocalDate.now()) || scadenzaPrenotazioni.isEqual(LocalDate.now()))
            throw new IllegalArgumentException("L'esperienza non può essere fissata oggi od in una data passata!");
        this.scadenzaPrenotazioni = scadenzaPrenotazioni;
    }

    @Override
    public int getGiorniRiservatezzaPosti() {
        return giorniRiservatezzaPosti;
    }

    @Override
    public void setGiorniRiservatezzaPosti(int giorniRiservatezzaPosti) {
        if (giorniRiservatezzaPosti < 2)
            throw new IllegalArgumentException("Giorni riservatezza inferiori a due");
        this.giorniRiservatezzaPosti = giorniRiservatezzaPosti;
    }
}
