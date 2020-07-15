package it.unipv.so.divisori.gui;


import it.unipv.so.divisori.gui.comandi.ICommand;
import it.unipv.so.divisori.modello.Sequenza;

/**
 * Classe che manda effettivamente in esecuzione il comando.
 *
 */
public class CommandExecutor {
	
	private Sequenza sequenza;
	/**
	 * Costruttore della classe CommandExecutor
	 */
	public CommandExecutor(Sequenza s) {
		sequenza = s;
	}
	
	/**
	 * Esegue il comando passato come parametro.
	 * @param command comando da eseguire
	 * @return result risultato del comando
	 */
	public String executeCommand(ICommand command) {
        return command.execute(sequenza);
    }

}
