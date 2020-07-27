package it.unipv.so.divisori.modello;
/**
 * Classe personalizzata che modella un numero. 
 * Il numero è identificato dal suo valore nominale e dal numero dei suoi divisori.
 * 
 */
public class Numero {
    private long value;
    private long divisors;

    /**
     * Costruttore della classe Numero. Crea un nuovo numero.
     *
     * @param valore
     * @param numero di divisori
     */
    public Numero(long value, long divisors) {
        this.value = value;
        this.divisors = divisors;
    }

    /**
     * Metodo get del valore
     * @return valore del numero
     */
    public long getValue() {
        return value;
    }

    /**
     * Metodo get del numero dei divisori
     * @return numero di divisori del numero
     */
    public long getDivisors() {
        return divisors;
    }
}
