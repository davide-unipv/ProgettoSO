package it.unipv.so.divisori.gui.comandi;

import it.unipv.so.divisori.modello.Sequenza;

public class NextCommand implements ICommand{

	@Override
	public String execute(Sequenza s) {
		s.computeNext();
		return null;
	}

}
