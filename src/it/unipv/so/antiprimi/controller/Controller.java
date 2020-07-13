package it.unipv.so.antiprimi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.so.antiprimi.gui.MainWindow;
import it.unipv.so.antiprimi.modello.Sequenza;

public class Controller {
	private MainWindow gui;
	private Sequenza s;
	public Controller(MainWindow gui, Sequenza s) {
		this.gui=gui;
		this.s=s;
		addListeners();
	}
	private void addListeners() {
		gui.getNext().addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent actionEvent) {
                s.computeNext();
            }
			
		});
		gui.getReset().addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent actionEvent) {
				s.reset();
            
            }
			
		});
		
		
		
		
	}

}
