package it.unipv.so.antiprimi.gui;


import javax.swing.*;

import it.unipv.so.antiprimi.modello.Numero;
import it.unipv.so.antiprimi.modello.Sequenza;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * The application window.
 */
public class MainWindow extends JFrame implements Observer {

    DefaultListModel display = new DefaultListModel();
    Pannello p;
    private static final int SHOW_LAST = 5;

    public MainWindow() {
        
        setTitle("Antiprimi");
        p=new Pannello();
        add(p);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        /*getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel("Last antiprimes found");
        label.setAlignmentX(Container.LEFT_ALIGNMENT);
        list.setAlignmentX(Container.LEFT_ALIGNMENT);
        getContentPane().add(label);
        getContentPane().add(list);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(nextBtn);
        buttonPane.add(resetBtn);
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.setAlignmentX(Container.LEFT_ALIGNMENT);
        getContentPane().add(buttonPane, BorderLayout.WEST);
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        */
    }

    public JButton getNext() {
		return p.getNext();
	}
	public JButton getReset() {
		return p.getReset();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		p.updateDisplay(o);
		
	}
}