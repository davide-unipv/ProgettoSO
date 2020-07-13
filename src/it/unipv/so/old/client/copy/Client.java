package it.unipv.so.old.client.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String message;
	private static final String IP_ADDRESS = "localhost";
	private static final int PORT = 8888;
	
	/**
	 * Costruttore della classe VendingMachineClient. 
	 * Istanzia la socket, il BufferedReader e il PrintWriter.
	 * @throws IOException eccezione di IO
	 */
	public Client() throws IOException {
		socket = new Socket(IP_ADDRESS, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}
	
	/**
	 * Invia al server le informazioni attuali della macchinetta.
	 * @param info informazioni sullo stato della vending machine
	 * @throws IOException eccezione di IO
	 */
	public String notifyServer(String info) throws IOException {
		out.println(info);
		return in.readLine();
	}

	/**
	 * Alla prima connessione, la macchinetta invia il suo tipo alla company
	 * e viene registrata, ricevendo il suo ID.
	 * @param type tipo della vending machine
	 * @return ID id della vending machine
	 * @throws IOException eccezione di IO
	 */
	public String getIdFromServer(String type) throws IOException {
		out.println(type);
		return in.readLine();
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
