package it.unipv.so.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import it.unipv.so.Services;

public class Client extends Thread{
	

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Services message;
	
	public Services getMessage() {
		return message;
	}

	public void setMessage(Services message) {
		this.message = message;
	}

	/**
	 * Costruttore della classe Client. 
	 * Istanzia la socket, il BufferedReader e il PrintWriter.
	 */
	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 8888);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	/**
	 * Invia al server una stringa.
	 * @param message2 informazioni da inviare al server
	 * @throws IOException eccezione di IO
	 */
	private void connectToServer(Services message2) throws IOException {
		out.println(message2);
		
	}
	
	public void closeConnection() throws IOException{
		socket.close();
	}
	/**
	 * Alla prima connessione il client invia una stringa di inizializzazione
	 * e riceve il suo ID.
	 * @param type stringa di inizializzazione
	 * @return ID id del client
	 * @throws IOException eccezione di IO
	 */
	public String firstConnectionToServer(String type) throws IOException {
		out.println(type);
		return in.readLine();
	}
	
	@Override
	public void run() {
		try {
			connectToServer(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
