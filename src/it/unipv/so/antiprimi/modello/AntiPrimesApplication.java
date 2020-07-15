package it.unipv.so.antiprimi.modello;

import javax.swing.*;

import it.unipv.so.antiprimi.gui.MainWindow;


/**
 * Class that setup the program.
 */
public class AntiPrimesApplication {
    private AntiPrimesSequence sequence;

    /**
     * Launch the program.
     */
    public static void main(String[] args) {
        AntiPrimesSequence sequence = new AntiPrimesSequence(8);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = new MainWindow(sequence);
                window.setVisible(true);
                sequence.addObserver(window);
            }
        });
    }


}
