package it.unipv.so.divisori.modello;

/**
 * Interface for objects that want to be notified when a AntiPrimesSequence changes.
 */
public interface Observer {

    /**
     * Notify the observer that the sequence changed.
     */
    void update();
}
