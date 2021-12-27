package Cicerone.interfaces;

/**
 *  Interfaccia che rappresenta una tappa, essa è caratterizzata da un id,un nome,una descrizione,
 *  una stringa che definisce come raggiungere la tappa (String raggiunta),un'Area e un territorio.
 *
 */
public interface I_Tappa {

    /**
     * Restituisce l'id della tappa
     * @return id percorso
     */
    String getId();

    /**
     * Ritorna il nome della tappa
     * @return nome
     */
    String getNome();

    /**
     * Inserisce il nome per la tappa
     * @param nome
     */
    void setNome(String nome);

    /**
     * Restituisce la descrizione della tappa
     * @return descrizione tappa
     */
    String getDescrizione();

    /**
     * Permette di inserire una descrizione per la tappa
     * @param descrizione
     */
    void setDescrizione(String descrizione);

    /**
     * Restituisce dettagli su come avvengono gli spostamenti verso(?) questa tappa
     * @return raggiunta
     */
    String getRaggiunta();

    /**
     * Permette di inserire dettagli su come avviene spostamento verso(?) questa tappa
     * @param raggiunta
     */
    void setRaggiunta(String raggiunta);

    /**
     * Ritorna  l'area della tappa
     * @return area
     */
    I_Area getArea();

    /**
     * Permette di inserire l'area della tappa
     * @param area
     */
    void setArea(I_Area area);


}
