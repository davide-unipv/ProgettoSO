package it.unipv.so.divisori.modello;
/**
 * Numero di cui sono stati contati i divisori
 */
public class Numero {
    private long value;
    private long divisors;

    /**
     * Crea un nuovo numero.
     *
     * @param valore
     * @param numero di divisori
     */
    public Numero(long value, long divisors) {
        this.value = value;
        this.divisors = divisors;
    }

    /**
     * Valore dell'attuale numero
     */
    public long getValue() {
        return value;
    }

    /**
     * Quanti divisori ho attualmente
     */
    public long getDivisors() {
        return divisors;
    }
}
