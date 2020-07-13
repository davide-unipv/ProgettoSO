package it.unipv.so.antiprimi.modello;
/**
 *  Classe personalizzata per un numero. Vengono conteggiati anche il numero dei divisori
 */
public class Numero {
	private long valore;
	private long divisori;

	/**
	 * Costruttore della classe Numero, permette di creare un nuovo numero.
	 *
	 * @param v valore del numero
	 * @param d numero dei suoi divisori
	 * 
	 */
	public Numero(long v, long d) {
		this.valore = v;
		this.divisori = d;
	}
	public long getValore() {
		return valore;
	}
	public long getDivisori() {
		return divisori;
	}
}