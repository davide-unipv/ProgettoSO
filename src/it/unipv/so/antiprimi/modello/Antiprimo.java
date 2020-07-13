package it.unipv.so.antiprimi.modello;

/**
 * Class containing auxiliary methods for the computation of antiprime numbers.
 */
public class Antiprimo {
	 /**
     * Return the smallest number greater than ap having more divisors than ap itself.
     */
    static public Numero nextAntiPrimeAfter(Numero ap) {
        long n = ap.getValore();
        long divisors;
        do {
            n++;
            divisors = countDivisors(n);
        } while (divisors <= ap.getDivisori());
        return new Numero(n, divisors);
    }

    /**
     * Count how many integers exactly divide n.
     */
    static public long countDivisors(long n) {
        long c = 1;
        for (long i = 2; i <= n; i++)
            if (n % i == 0)
                c++;
        return c;
    }
	}


