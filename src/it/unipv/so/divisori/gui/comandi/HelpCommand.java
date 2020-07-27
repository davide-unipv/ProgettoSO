package it.unipv.so.divisori.gui.comandi;


import it.unipv.so.divisori.modello.Sequenza;

/**
 * Il comando permette di visualizzare i comandi disponibili, con una breve descrizione.
 *
 */
public class HelpCommand implements ICommand {

	@Override
	public String execute(Sequenza s) {
		String help;
		help = CostruisciStriga();
		return help;
	}
	/**
	 * Metodo di supporto per costruire la stringa
	 * @return stringa da visualizzare sul prompt
	 * 
	 */
	private String CostruisciStriga() {
		StringBuilder helpResultBuilder = new StringBuilder("I comandi disponibili sono i seguenti.\n");
		helpResultBuilder.append("next: Calcola il prossimo numero \n");
		helpResultBuilder.append("reset: Resetta la lista introducendo solo il numero '1' \n");
		helpResultBuilder.append("stop: Termina il programma \n");
		return helpResultBuilder.toString();
	}

}
