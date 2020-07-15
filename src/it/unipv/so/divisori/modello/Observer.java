package it.unipv.so.divisori.modello;

/**
 * Interfaccia per gli oggetti che vogliono essere 
 * notificati quando un nuovo numero e' stato trovato.
 * 
 */
public interface Observer {

    /**
     * Notifica gli osservatori che qualcosa è cambiato.
     */
    void update();
}
