package it.unipv.so.antiprimi;

import javax.swing.SwingUtilities;

import it.unipv.so.antiprimi.gui.MainWindow;
import it.unipv.so.antiprimi.modello.Sequenza;


public class Launcher {
	    /**
	     * Lancia il programma.
	     */
	  public static void main(String[] args) {
	        Sequenza sequence = new Sequenza(8);
	        
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	MainWindow window = new MainWindow(sequence);
	                sequence.addObserver(window);
	            }
	        });
	    }

}
