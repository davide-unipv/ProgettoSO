package it.unipv.so.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
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
	 * @param info informazioni da inviare al server
	 * @throws IOException eccezione di IO
	 */
	public void connectToServer(String info) throws IOException {
		out.println(info);
		
	}
	public void closeConnectioen() throws IOException{
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
}
