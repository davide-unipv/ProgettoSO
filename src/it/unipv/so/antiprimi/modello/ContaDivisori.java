package it.unipv.so.antiprimi.modello;

import java.util.logging.Logger;

/**
 * Independent thread that counts the divisors of numbers.  This class is used by NumberProcessorMT to make parallel
 * the search for antiprime numbers.
 */
public class ContaDivisori extends Thread {

    //private final static Logger LOGGER = Logger.getLogger(DivisorCounter.class.getName());

    /**
     * Corresponding number processor.
     */
    Processor numberProcessor;

    /**
     * Create a new instance for the givev processor.
     */
    public ContaDivisori(Processor np) {
        numberProcessor = np;
    }

    /**
     * Thread body.
     */
    public void run() {
        for (;;) {
            try {
                //LOGGER.info(currentThread().getName() + ": ask for a new integer to process");
                System.out.println(currentThread().getName()+ " richiede un nuovo intero da processare");
                long n = numberProcessor.nextNumberToProcess();
                //LOGGER.info(currentThread().getName() + " start to process " + n);
                System.out.println(currentThread().getName()+ " inizio calcolo "+ n);
                long d = Antiprimo.countDivisors(n);
                //LOGGER.info(currentThread().getName() + " found that " + n + " has " + d + " divisors");
                System.out.println(currentThread().getName() + " ha trovato " + n + " con " + d + " divisori");
                numberProcessor.passResult(new Numero(n, d));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
