package it.unipv.so.divisori;

import javax.swing.SwingUtilities;

import it.unipv.so.divisori.gui.Terminal;
import it.unipv.so.divisori.modello.Sequenza;
/**
 * La classe serve per inizializzare le varibili e lanciare il programma.
 * */
public class Launcher {	
    /**
     * Lancia il programma.
     */
    public static void main(String[] args) {
        Sequenza sequence = new Sequenza(8);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Terminal window = new Terminal(sequence);
                window.setVisible(true);
                sequence.addObserver(window);
            }
        });
    }

}
