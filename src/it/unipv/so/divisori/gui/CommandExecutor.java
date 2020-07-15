package it.unipv.so.divisori.gui;


import it.unipv.so.divisori.gui.comandi.ICommand;
import it.unipv.so.divisori.modello.Sequenza;

/**
 * Classe che manda effettivamente in esecuzione il comando.
 *
 */
public class CommandExecutor {
	
	private Sequenza vendingMachine;

	public CommandExecutor(Sequenza s) {
		vendingMachine = s;
	}
	
	/**
	 * Esegue il comando passato come parametro con gli argomenti, anch'essi
	 * ricevuti dal chiamante.
	 * @param command comando da eseguire
	 * @param args argomenti del comando
	 * @return result risultato del comando
	 */
	public String executeCommand(ICommand command) {
        return command.execute(vendingMachine);
    }

}
