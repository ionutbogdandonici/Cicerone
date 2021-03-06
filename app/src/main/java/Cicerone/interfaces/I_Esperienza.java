package Cicerone.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interfaccia che rappresenta una esperienza
 */
public interface I_Esperienza {

    /**
     * Ritorna la data dell'esperienza
     *
     * @return data esperienza
     */
    LocalDate getDataEsperienza();

    /**
     * Imposta o aggiorna la data di una determinata esperienza
     *
     * @param dataEsperienza nuova data
     */
    void setDataEsperienza(LocalDate dataEsperienza);

    /**
     * Restituisce il nome di un data esperienza
     *
     * @return nome esperienza
     */
    String getNome();

    /**
     * Imposta o aggiorna il nome di una data esperienza
     *
     * @param nome dell'esperienza
     */
    void setNome(String nome);

    /**
     * Ritorna la descrizione dell'esperienza
     *
     * @return descrizione
     */
    String getDescrizione();

    /**
     * Imposta o aggiorna la descrizione dell'esperienza
     *
     * @param descrizione la nuova descrizione
     */
    void setDescrizione(String descrizione);

    /**
     * Ritorna il percorso dell'esperienza
     *
     * @return percorso
     */
    I_Percorso getPercorso();

    /**
     * Imposta o aggiorna il percorso di una esperienza
     * Una esperienza senza il percorso non esiste
     *
     * @param percorso da assegnare all'esperienza
     */
    void setPercorso(I_Percorso percorso);

    /**
     * Ritorna tutti gli tag attribuiti a questa esperienza
     *
     * @return lista tag
     */
    ArrayList<I_Tag> getTags();

    /**
     * Aggiunge un nuovo tag all'esperienza
     * @param tag da aggiungere
     */
    void addTag(I_Tag tag);

    /**
     * Rimuove un tag da questa esperienza
     *
     * @param tag da rimuovere
     * @return <code>true</code> se il tag &egrave; stato rimosso <code>false</code> altrimenti
     */
    boolean removeTag(I_Tag tag);
    /**
     * Ritorna il costo dell'esperienza
     *
     * @return costo
     */
    float getCosto();

    /**
     * Imposta o aggiorna il costo dell'esperienza
     *
     * @param costo nuovo
     */
    void setCosto(float costo);

    /**
     * Ritorna il numero di posti massimo per una data esperienza
     *
     * @return posti massimi
     */
    int getPostiMax();

    /**
     * Imposta il numero di posti massimo per una determinata esperienza
     *
     * @param postiMax numero massimo di posti
     */
    void setPostiMax(int postiMax);

    /**
     * Ritorna il numero di posti minimo per una determinata esperienza
     *
     * @return posti minimi
     */
    int getPostiMin();

    /**
     * Imposta il numero di posti minimo per una determinata esperienza
     * Se questo numero non viene raggiunto l'esperienza non si pu?? fare
     *
     * @param postiMin numero posti minimi
     */
    void setPostiMin(int postiMin);

    /**
     * Ritorna il numero di posti attualmente riservati, questo numero conta solamente
     * i posti effettivamente prenotati, ovvero pagati.
     *
     * @return posti riservati
     */
    int getPostiRiservati();

    /**
     * Incrementa il numero di posti riservati
     * @return numero attuale di posti riservati
     */
    int incrementaPostiRiservati();

    /**
     * Ritorna il numero di posti attualmente prenotati ma non ancora pagati
     * Alla scadenza di ogni timeout di ogni invito il numero diminuisce
     * Questo aumenta invece, quando un Utente invia un invito ad un amico
     *
     * @return posti prenotati ma non pagati
     */
    int getPostiInSospeso();

    /**
     * Incrementa il numero di posti riservati ma non confermati
     * @return numero attuale di posti riservati ma non confermati
     */
    int incrementaPostiRiservatiMaNonConfermati();
    /**
     * Ritorna l'ultimo giorno in cui ?? possibile effettuare delle prenotazioni
     *
     * @return scadenza prenotazioni
     */
    LocalDate getScadenzaPrenotazioni();

    /**
     * Imposto o aggiorna la data di scadenza delle prenotazioni
     *
     */
    void setScadenzaPrenotazioni();

    /**
     * Ritorna il numero di giorni a disposizione dell'invitante ad accettare l'invito
     *
     * @return giorni riservatezza
     */
    int getGiorniRiservatezzaPosti();

    /**
     * Imposta o aggiorna il numero di giorni a disposizione di un utente ad accettare un invito
     * Questo non pu?? essere inferiore a 2
     *
     * @param giorniRiservatezzaPosti numero di giorni nuovo
     */
    void setGiorniRiservatezzaPosti(int giorniRiservatezzaPosti);
}
