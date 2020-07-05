package it.unipv.so.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import it.unipv.so.Services;

public class ConnectedClient extends Thread{
private Socket socket;
	
	/**
	 * Il costruttore si occupa solo di istanziare la socket della connessione.
	 * @param socket
	 */
	public ConnectedClient(Socket socket) {
		this.socket = socket;
	}
		
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			String vmMessage = in.readLine();
			if(vmMessage.equals("FATTORIALE")) System.out.println(fattoriale(3));
			else System.out.println("non posso fare nulla");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int fattoriale(int x) {
		  int i;
		    int f=1;
		    for(i=1; i<=x; i=i+1) {
		      f=f*i;
		    }
		return f;
	}
}
