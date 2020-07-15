package it.unipv.so.divisori.modello;


import java.util.logging.Logger;

/**
 * Classe che sfrutta il multithreading per cercare numeri in background
 *
 * La richiesta è in request. Dopo ogni richiesta di 'toProcess' viene valutato il numero successivo. 
 *
 */
public class ProcessaNumeri {

    private final static Logger LOGGER = Logger.getLogger(ProcessaNumeri.class.getName());

    /**
     * Il successivo dell'attuale che deve essere calcolato
     */
    private Numero request;

    /**
     * Prossimo numero che va valutato
     */
    private long toProcess;

    /**
     * Ultimo numero valutato
     */
    private long processed;

    /**
     * Sequenza di numeri calcolati
     */
    private Sequenza sequence;


    public ProcessaNumeri(Sequenza sequence) {
        this.sequence = sequence;
    }

    /**
     * Inizia il calcolo con il numero di thread precisato
     */
    public void startThreads(int poolSize) {
        for (int i = 0; i < poolSize; i++)
            new ContaDivisori(this).start();
    }

    /**
     * Chiede di processare il successivo
     *
     * Se processor è bloccato, verrà interrotta la richiesta
     */
    synchronized public void nextAntiPrime(Numero n) throws InterruptedException {
        while (request != null) {
            if (request.getValue() == n.getValue())
                return;
            wait();
        }
        request = n;
        processed = request.getValue();
        toProcess = request.getValue() + 1;
        System.out.println("\n\nRichiesta di calcolare " + n.getValue());
        //LOGGER.info("Asked to find the successor of " + n.getValue());
        notifyAll();
    }

    /**
     * Libera il processor
     */
    synchronized private void acceptRequests() {
        request = null;
        notifyAll();
    }

    /**
     * Usato per avere un numero da processare
     * Se non c'è nulla da processare, il thread viene bloccato
     */
    synchronized public long nextNumberToProcess() throws InterruptedException {
        while (request == null)
            wait();
        return toProcess++;
    }

    /**
     * Qui i thread comunicano il risultato
     */
    synchronized public void passResult(Numero number) throws InterruptedException {
        while (request != null && number.getValue() != processed + 1)
            wait();
        if (request == null)
            return;
        if (number.getDivisors() > request.getDivisors()) {
            // A new antiprime has been found!
            processed++;
            sequence.addAntiPrime(number);
            acceptRequests();
        } else if (number.getValue() == processed + 1) {
            processed++;
            notifyAll();
        }
    }
}
