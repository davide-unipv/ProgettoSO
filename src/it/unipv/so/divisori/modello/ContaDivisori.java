package it.unipv.so.divisori.modello;

/**
 * La classe implementa il corpo di ogni thread.
 * 
 */
public class ContaDivisori extends Thread {

    ProcessaNumeri numberProcessor;
    /**
 	* Costruttore della classe ContaDivisori.
 	* @param np istanza della classe ProcessaNumeri
 	* 
 	* */
    public ContaDivisori(ProcessaNumeri np) {
        numberProcessor = np;
    }
    /**
     * Azioni che esegue ogni thread.
     * 
     */
    public void run() {
        while(true) {
            try {
                System.out.println(currentThread().getName()+ " richiede un nuovo numero da processare");
                long n = numberProcessor.nextNumberToProcess();
                System.out.println(currentThread().getName()+ " inizio calcolo "+ n);
                long d = contaDivisori(n);
                System.out.println(currentThread().getName() + " ha trovato " + n + " con " + d + " divisori");
                numberProcessor.passaRisultato(new Numero(n, d));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        
    /**
     * Il metodo permette di contare i divisori di un numero.
     * @param n numero di cui dobbiamo contare i divisori.
     * @return numero dei divisori dell'argomento.
     */
    private static long contaDivisori(long n) {
        long c = 1;
        for (long i = 2; i <= n; i++)
            if (n % i == 0)
                c++;
        return c;
    }
    
}
