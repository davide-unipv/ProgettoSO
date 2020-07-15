package it.unipv.so.divisori.modello;

import java.util.ArrayList;
import java.util.List;


/**
 * Represent the sequence of antiprimes found so far.
 */
public class Sequenza {

    /**
     * The numbers in the sequence.
     */
    private List<Numero> antiPrimes = new ArrayList<>();

    /**
     * Object which processes the numbers.
     */
    private ProcessaNumeri processor;

    /**
     * List of objects observing the sequence.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * Create a new sequence containing only the first antiprime (the number '1').
     *
     * @param poolSize numero di thread concorrenti usati per il calcolo.
     */
    public Sequenza(int poolSize) {
        processor = new ProcessaNumeri(this);
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
    public void addObserver(Observer observer) {
        observers.add(observer);
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
    synchronized public void addAntiPrime(Numero number) {
        antiPrimes.add(number);
        for (Observer observer : observers)
            observer.update();
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
    synchronized public List<Numero> getAll() {
        return antiPrimes;
    }
}
