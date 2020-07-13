package it.unipv.so.antiprimi.gui;

import java.awt.LayoutManager;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class Pannello extends JPanel {
	
	//DefaultListModel display = new DefaultListModel();
	private static final int SHOW_LAST = 5;
	private JButton next;
	private JButton reset;
	private JTextArea lista;
	
	public Pannello() {
		JLabel label = new JLabel("Questi sono gli ultimi antiprimi trovati");
		//JScrollPane list = new JScrollPane(new JList(display));
		lista=new JTextArea(); 
		next = new JButton("Next");
		reset = new JButton("Reset");
		//updateDisplay();
		add(label);
		add(lista);
		add(next);
		add(reset);


	}
	/**
	 * Change the list showing the last antiprimes found so far.
	 */
	
	 
	 public void updateDisplay(Observable o) { 
		 
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                 String s=lista.getText();
	                 Numero n=o
	            }
	        });
		
		 
		 //for (Numero n : sequence.getLastK(SHOW_LAST)) 
		//	 display.add(0, "" + n.getValore() + " (" +n.getDivisori() + ")"); 
	}
	 

	public JButton getNext() {
		return next;
	}
	public JButton getReset() {
		return reset;
	}
	private String getText() {
		return lista.getText();
	}
	private void setText() {
		lista.setText(t);
	}
	

}
