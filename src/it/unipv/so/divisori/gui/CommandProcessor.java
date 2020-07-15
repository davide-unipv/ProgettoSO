package it.unipv.so.divisori.gui;


import it.unipv.so.divisori.gui.comandi.HelpCommand;
import it.unipv.so.divisori.gui.comandi.NextCommand;
import it.unipv.so.divisori.gui.comandi.ResetCommand;
import it.unipv.so.divisori.gui.comandi.StopCommand;
import it.unipv.so.divisori.modello.Sequenza;

/**
 * Classe che permette di processare e mandare in esecuzione i programmi
 * digitati dal terminale.
 *
 */
public class CommandProcessor {
	
	private CommandExecutor cmdExecutor;

	public CommandProcessor(Sequenza s) {
		cmdExecutor = new CommandExecutor(s);
	}
	
	/**
	 * Riceve la riga di comando con gli argomenti e manda in esecuzione
	 * il relativo comando.
	 * @param commandln la riga di comando 
	 * @return result il risultato del comando
	 */
	public String processCommand(String commandln) {
		String[] commandSplit = commandln.split(" ");
	    String command = commandSplit[0].trim();
	    String cmdArgs = null;
	    if (commandln.length() > command.length() + 1)
	    	cmdArgs = commandln.substring(command.length() + 1);
	    
	    String result;
	    if (command.equalsIgnoreCase(Commands.HELP)) {
	    	result = cmdExecutor.executeCommand(new HelpCommand());
		} else if (command.equalsIgnoreCase(Commands.STOP)) {
	    	result = cmdExecutor.executeCommand(new StopCommand());
	    } else if (command.equalsIgnoreCase(Commands.NEXT)) {
	    	result = cmdExecutor.executeCommand(new NextCommand());
	    }else if (command.equalsIgnoreCase(Commands.RESET)) {
	    	result = cmdExecutor.executeCommand(new ResetCommand());
	    }else {
	    	result = "Comando non trovato";
	    }
	    
	    return result;
	}
	
}
