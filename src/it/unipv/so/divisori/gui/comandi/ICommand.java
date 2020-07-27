package it.unipv.so.divisori.gui.comandi;


import it.unipv.so.divisori.modello.Sequenza;

/**
 * Interfaccia che devono implementare tutti i comandi
 * eseguibili tramite terminale.
 *
 */
public interface ICommand {

	/**
	 * Il metodo viene implementato per ogni istruzione possibile dalle classe che estendono l'interfaccia ICommand.
	 * @param s istanza della classe Sequenza
	 * @return result risultato del comando
	 * 
	 */
	String execute(Sequenza s);
	
}
