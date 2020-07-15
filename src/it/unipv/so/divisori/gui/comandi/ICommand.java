package it.unipv.so.divisori.gui.comandi;


import it.unipv.so.divisori.modello.Sequenza;

/**
 * Interfaccia che devono implementare tutti i comandi
 * eseguibili tramite terminale.
 *
 */
public interface ICommand {

	/**
	 * Esegue le azioni effettive del comando.
	 * @param s istanza della classe Sequenza
	 * @return result risultato del comando
	 */
	String execute(Sequenza s);
	
}
