package Cicerone.interfaces;

public interface I_Tag {

    /**
     * Ritorna l'ID del tag
     * @return ID Tag
     */
    int getID();

    /**
     * Ritorn il nome del tag in base al ID
     * @param ID l'ID del tag
     * @return nome tag
     */
    String getNome(int ID);

    /**
     * Inserisce un nuovo tag
     * @return <code>True</code> se il tag &egrave; stato inserito con successo, <code>false</code> se il tag
     * &egrave; gi&agrave; presente
     */
    boolean addNome();

    /**
     * Rimuove un tag dall'insieme del database
     * @param ID del tag da rimuovere
     * @return <code>True</code> se il tag &egrave; stato rimosso con successo, <code>false</code> se il tag
     * non &egrave; presente
     */
    boolean remove(int ID);

}
