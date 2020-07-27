package it.unipv.so.divisori.modello;
/**
 * Classe personalizzata che modella un numero. 
 * Il numero è identificato dal suo valore nominale e dal numero dei suoi divisori.
 * 
 */
public class Numero {
    private long valore;
    private long divisori;

    /**
     * Costruttore della classe Numero. Crea un nuovo numero.
     *
     * @param valore valore effettivo del numero.
     * @param divisori numero di divisori.
     */
    public Numero(long valore, long divisori) {
        this.valore = valore;
        this.divisori = divisori;
    }

    /**
     * Metodo get del valore.
     * @return valore del numero.
     */
    public long getValore() {
        return valore;
    }

    /**
     * Metodo get del numero dei divisori.
     * @return numero di divisori del numero.
     */
    public long getDivisori() {
        return divisori;
    }
}
