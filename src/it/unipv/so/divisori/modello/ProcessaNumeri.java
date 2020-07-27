package it.unipv.so.divisori.modello;


/**
 * Classe che sfrutta il multithreading per cercare numeri in background.
 * La richiesta del numero da cercare è nella variabile 'richiesta'. 
 * Dopo ogni richiesta di 'daProcessare' viene valutato il numero successivo. 
 *
 */
public class ProcessaNumeri {

    /**
     * Il successivo dell'attuale che deve essere calcolato.
     */
    private Numero richiesta;

    /**
     * Prossimo numero che va valutato.
     */
    private long daProcessare;

    /**
     * Ultimo numero valutato.
     */
    private long processato;

    /**
     * Sequenza di numeri calcolati.
     */
    private Sequenza sequenza;

    /**
     * Costruttore della classe ProcessaNumeri.
     * @param s sequenza dei numeri memorizzati fino ad ora.
     */
    public ProcessaNumeri(Sequenza s) {
        this.sequenza = s;
    }

    /**
     * Inizia il calcolo con il numero di thread specificato.
     * @param nThread numero di thread
     */
    public void startThreads(int nThread) {
        for (int i = 0; i < nThread; i++)
            new ContaDivisori(this).start();
    }

    /**
     * Il metodo permette di processare il successivo numero. 
     * Se il ProcessaNumeri e' bloccato, verra' interrotta la richiesta.
     * @param n il numero che viene richiesto.
     * @throws InterruptedException l'eccezione viene lanciata se l'esecuzione viene interrotta.
     */
    synchronized public void nextNumber(Numero n) throws InterruptedException {
        while (richiesta != null) {
            if (richiesta.getValore() == n.getValore())	return;
            wait();
        }
        richiesta = n;
        processato = richiesta.getValore();
        daProcessare = richiesta.getValore() + 1;
        System.out.println("\n\nRichiesta di calcolare " + n.getValore());
        notifyAll();
    }

    /**
     * Il metodo permette di liberare il ProcessaNumeri.
     */
    synchronized private void acceptRequests() {
        richiesta = null;
        notifyAll();
    }

    /**
     * Il metodo serve per avere un numero da processare.
     * Se non c'e' nulla da processare, il thread viene bloccato.
     * 
     * @throws InterruptedException l'eccezione viene lanciata se l'esecuzione viene interrotta.
     * @return il prossimo numero da processare.
     */
    synchronized public long nextNumberToProcess() throws InterruptedException {
        while (richiesta == null)	wait();
        return daProcessare++;
    }

    /**
     * Qui i thread comunicano il risultato.
     * @param n risultato del thread.
     * @throws InterruptedException l'eccezione viene lanciata se l'esecuzione viene interrotta.
     */
    synchronized public void passaRisultato(Numero n) throws InterruptedException {
        while (richiesta != null && n.getValore() != processato + 1)	wait();
        if (richiesta == null)	return;
        if (n.getDivisori() > richiesta.getDivisori()) {
            processato++;
            sequenza.aggiungiNumero(n);
            acceptRequests();
        } else if (n.getValore() == processato + 1) {
            processato++;
            notifyAll();
        }
    }
}
