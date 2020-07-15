package it.unipv.so.divisori.gui.comandi;

import it.unipv.so.divisori.modello.Sequenza;

public class ResetCommand implements ICommand{

	@Override
	public String execute(Sequenza s) {
		s.reset();
		return null;
	}

}
