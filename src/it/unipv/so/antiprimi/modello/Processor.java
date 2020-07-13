package it.unipv.so.antiprimi.modello;


import java.util.logging.Logger;

/**
 * Class representing an obejct using multiple threads to searche antiprime numbers in background.
 *
 * A request is stored in the 'request' member.  After each request 'toProcess' is initilized to the next integer to
 * evaluate as possible antiprime.  Similarly, 'processed' is set to the last number already analyzed.
 *
 * Multiple threads ask number to process and return asynchronously its count of divisors.  When a number with more
 * divisor than 'request' is found it is signaled as antiprime to the sequence object. At that point the search is
 * terminated.
 */
public class Processor {

    private final static Logger LOGGER = Logger.getLogger(Processor.class.getName());

    /**
     * The antiprime of which the successor must be computed.
     */
    private Numero request;

    /**
     * The next number that need to be evaluated.
     */
    private long toProcess;

    /**
     * The last number that has been evaluated.
     */
    private long processed;

    /**
     * The sequence of antiprimes that is extended by the processor.
     */
    private Sequenza sequence;

    /**
     * Create a new processor for the given sequence of antiprimes.
     */
    public Processor(Sequenza sequence) {
        this.sequence = sequence;
    }

    /**
     * Start the computing threads whose number is given by 'poolSize'.
     */
    public void startThreads(int poolSize) {
        for (int i = 0; i < poolSize; i++)
            new ContaDivisori(this).start();
    }

    /**
     * Ask the processor to compute the successor of n in the antiprime sequence.
     *
     * If the processor is busy the caller will block until the processor can receive the request.
     * The method will return without waiting the end of the computation.
     */
    synchronized public void nextAntiPrime(Numero numero) throws InterruptedException {
        while (request != null) {
            if (request.getValore() == numero.getValore())
                return;
            wait();
        }
        request = numero;
        processed = request.getValore();
        toProcess = request.getValore() + 1;
        System.out.println("\n\nRichiesta di calcolare " + numero.getValore());
        //LOGGER.info("Asked to find the successor of " + n.getValue());
        notifyAll();
    }

    /**
     * Make the processor ready for new computations.
     */
    synchronized private void acceptRequests() {
        request = null;
        notifyAll();
    }

    /**
     * Used by the threads to obtain a number to process.
     * If no processing is needed then the thread is blocked.
     */
    synchronized public long nextNumberToProcess() throws InterruptedException {
        while (request == null)
            wait();
        return toProcess++;
    }

    /**
     * Used by the threads to communicating back the result of their computation.
     * Each thread has to wait its turn so that no antiprimes are skipped.
     */
    synchronized public void passResult(Numero numero) throws InterruptedException {
        while (request != null && numero.getValore() != processed + 1)
            wait();
        if (request == null)
            return;
        if (numero.getDivisori() > request.getDivisori()) {
            // A new antiprime has been found!
            processed++;
            sequence.addAntiPrime(numero);
            acceptRequests();
        } else if (numero.getValore() == processed + 1) {
            processed++;
            notifyAll();
        }
    }
}
