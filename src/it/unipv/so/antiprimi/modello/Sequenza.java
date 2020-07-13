package it.unipv.so.antiprimi.modello;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.unipv.so.antiprimi.gui.MainWindow;


/**
 * Represent the sequence of antiprimes found so far.
 */
public class Sequenza extends Observable{

    /**
     * The numbers in the sequence.
     */
    private List<Numero> antiPrimes = new ArrayList<>();

    /**
     * Object which processes the numbers.
     */
    private Processor processor;


    /**
     * Create a new sequence containing only the first antiprime (the number '1').
     *
     * @param poolSize numero di thread concorrenti usati per il calcolo.
     */
    public Sequenza(int poolSize) {
        processor = new Processor(this);
        this.reset();
        processor.startThreads(poolSize);
    }

    /**
     * Create a new sequence with a default number of concurrent threads.
     */
    public Sequenza() {
        this(8);
    }

    /**
     * Register a new observer.
     */
    public void addObserver(MainWindow observer) {
    	this.addObserver(observer);
    }

    /**
     * Clear the sequence so that it contains only the first antiprime (the number '1').
     */
    synchronized public void reset() {
        antiPrimes.clear();
        addAntiPrime(new Numero(1, 1));
    }

    /**
     * Extend the sequence to include a new antiprime.
     */
    synchronized public void addAntiPrime(Numero numero) {
        antiPrimes.add(numero);
        this.notifyObservers();
    }

    /**
     * Find a new antiprime and add it to the sequence.
     */
    public void computeNext() {
        try {
            processor.nextAntiPrime(getLast());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the last antiprime found.
     */
    synchronized public Numero getLast() {
        int n = antiPrimes.size();
        return antiPrimes.get(n - 1);
    }

    /**
     * Return the last k antiprimes found.
     */
    synchronized public List<Numero> getLastK(int k) {
        int n = antiPrimes.size();
        if (k > n)
            k = n;
        return antiPrimes.subList(n - k, n);
    }
}
