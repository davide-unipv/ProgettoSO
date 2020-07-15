package it.unipv.so.divisori.gui.comandi;

import it.unipv.so.divisori.modello.Sequenza;

/**
 * Comando che ferma l'esecuzione del programma.
 *
 */
public class StopCommand implements ICommand {

	@Override
	public String execute(Sequenza s) {
		System.exit(0);
		return null;
	}

}
