package it.unipv.so.divisori.gui.comandi;


import it.unipv.so.divisori.modello.Sequenza;

/**
 * Comando che permette di visualizzare tutta la lista dei comandi
 * disponibili, con una breve descrizione.
 *
 */
public class HelpCommand implements ICommand {

	@Override
	public String execute(Sequenza s) {
		String helpResult;
		helpResult = buildHelpResult();
		return helpResult;
	}

	private String buildHelpResult() {
		StringBuilder helpResultBuilder = new StringBuilder("I comandi disponibili sono i seguenti:\n");
		helpResultBuilder.append("next -> calcola nuovo \n");
		helpResultBuilder.append("reset -> reset \n");
		helpResultBuilder.append("stop -> Termina il programma.\n");
		return helpResultBuilder.toString();
	}

}
