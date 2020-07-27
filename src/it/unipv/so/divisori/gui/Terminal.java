package it.unipv.so.divisori.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import it.unipv.so.divisori.modello.Numero;
import it.unipv.so.divisori.modello.Observer;
import it.unipv.so.divisori.modello.Sequenza;

/**
 * JFrame che contiene una JTextArea che permette di simulare
 * il comportamento di un terminale.
 *
 *
 */
@SuppressWarnings("serial")
public class Terminal extends JFrame implements Observer{
	private Sequenza sequence;
	private CommandProcessor cmdProcessor;
	private static final int WIDTH = 500, HEIGHT = 400;
	private JTextArea commandLine;
	
	public Terminal(Sequenza sequence) {
		this.sequence = sequence;
		cmdProcessor = new CommandProcessor(sequence);
		setTitle("Progetto Sistemi Operativi");
		setSize(WIDTH, HEIGHT);
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		container.add(panel);
		panel.setLayout(new BorderLayout());
		
		commandLine = new JTextArea();
		setInitString();
		setPrompt();
		commandLine.setFont(commandLine.getFont().deriveFont(Font.BOLD, 16));
		commandLine.setForeground(Color.WHITE);
		commandLine.setBackground(Color.BLACK);
		commandLine.setLineWrap(true);
		commandLine.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(commandLine);
		scrollPane.setBorder(null);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getCommandLine().addKeyListener(new KeyListener() { 
			//imposta il listener al terminale che processa il comando alla pressione di Enter
		    @Override
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	e.consume();
		        	commandLine.append("\n");
		        	print(cmdProcessor.processCommand(getCommand().substring(2)));
		        	commandLine.append("\n");
		        	setPrompt();
		        }
		    }
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
	}
	
	/**
	 * Restituisce l'ultima linea dell'area di testo.
	 * @return il comando inserito.
	 */
	private String getCommand() {
		String[] lines = commandLine.getText().split("\n");
		return lines[commandLine.getLineCount() - 2];
	}
	
	/**
	 * Inserisce il carattere '$' nell'area di testo.
	 * 
	 */
	private void setPrompt() {
		commandLine.append("$ ");
	}
	
	/**
	 * Stampa nell'area di testo la stringa passatagli come parametro.
	 * @param string testo da stampare.
	 */
	private void print(String string) {
		commandLine.append(string);
	}
	/**
	 * Stampa nell'area di testo una stringa di inizializzazione predefinita.
	 * 
	 */
	private void setInitString() {
		commandLine.append("Utilizzare il comando 'help' per informazioni\n");
	}
	/**
	 * Restituisce la JTextArea.
	 * @return la JTextArea.
	 */
	public JTextArea getCommandLine() {
		return commandLine;
	}
	
	/**
	 * Stampa sul prompt la nuova lista dei numeri insieme al nuovo prompt.
	 * 
	 */
	private void updatePrompt() {
		String s = "";
		commandLine.setText("");
		setInitString();
		for (Numero n : sequence.getAll()) {
			s+="" + n.getValue() + " (" + n.getDivisors() + ")\n";
		}
		print(s);
		setPrompt();
	}
	
	@Override
	public void update() {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	updatePrompt();
            }
        });
		
	}

}
