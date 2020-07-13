package it.unipv.so.old.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import it.unipv.so.old.Services;
import it.unipv.so.old.server.operations.Fattoriale;
import it.unipv.so.old.server.operations.Fibonacci;


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
		String message;
		
		
		//http://wiki.tes.mi.it/index.php/Zanetti-chat_client/server_java
               
           

				message = in.readLine();
				if (message != null) { //se il messaggio ricevuto è nullo non fa niente e chiude la socket
					String[] msgParts = message.split("/");
					Services s=Services.valueOf(msgParts[0]);
					int limit=Integer.parseInt(msgParts[1]);
					if(s==Services.FATTORIALE) {
						int result = Fattoriale.fattoriale(limit);
						out.println(result);
					}else if(s==Services.FIBONACCI) {
						String result = Fibonacci.fibb(limit);
						out.println(result);
					}
				}
		
				socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
