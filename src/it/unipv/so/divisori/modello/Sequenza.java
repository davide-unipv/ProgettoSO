package it.unipv.so.divisori.modello;

import java.util.ArrayList;
import java.util.List;


/**
 * Rappresenta la sequenza di numeri trovati fino ad ora. 
 * 
 */
public class Sequenza {

    private List<Numero> numeri = new ArrayList<>();
    private ProcessaNumeri processor;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Crea una nuova sequenza contenente solamente il primo numero (ovvero il numero '1').
     * @param numeroThread numero di thread concorrenti usati per il calcolo.
     * 
     */
    public Sequenza(int numeroThread) {
        processor = new ProcessaNumeri(this);
        this.reset();
        processor.startThreads(numeroThread);
    }

     /**
     * Registra un nuovo observer.
     * @param observer oggetto che implementa l'interfaccia Observer.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    /**
     * Il metodo permette di avviare il calcolo di nuovo numero. 
     * Il metodo e' chiamato dal prompt attraverso il comando 'next'.
     *
     */
    public void calcolaSuccessivo() {
        try {
            processor.nextNumber(getLast());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Estende la sequenza dei numeri aggiungendo il nuovo numero 
     * alla lista e notifica gli observer.
     * @param number numero da aggiungere alla lista.
     */
    synchronized public void aggiungiNumero(Numero number) {
    	numeri.add(number);
        for (Observer observer : observers)
            observer.update();
    }
    
    /**
     * Inizializza la sequenza dei numeri, inserendo solo il primo numero (il numero '1').
     */
    synchronized public void reset() {
    	numeri.clear();
        aggiungiNumero(new Numero(1, 1));
    }

    /**
     * Restituisce l'ultimo numero trovato.
     * @return l'ultimo elemento aggiunto alla lista
     * 
     */
    synchronized private Numero getLast() {
        int n = numeri.size();
        return numeri.get(n - 1);
    }

    /**
     * Restituisce tutta la lista.
     * @return l'intera lista dei numeri
     */
    synchronized public List<Numero> getAll() {
        return numeri;
    }
}