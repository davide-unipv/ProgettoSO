package it.unipv.so.divisori.gui.comandi;

import java.io.IOException;

import it.unipv.so.divisori.modello.Sequenza;

/**
 * Comando che ferma l'esecuzione del programma, tentando di inviare
 * le informazioni alla Company prima dello spegnimento.
 *
 */
public class StopCommand implements ICommand {

	@Override
	public String execute(Sequenza s) {
	
		System.exit(0);
		
		return null;
	}

}
