package it.unipv.so.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Server extends Thread{
	private int port;

	/**
	 * Il costruttore istanzia solamente il numero di porta
	 * @param numero di porta
	 */
	public Server(int port) {
		this.port = port;
	}

	/**
	 * Permette di accettare continuamente nuove connessioni.
	 */
	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);
			
			while (true) {
				Socket socket = serverSocket.accept();
				ConnectedClient client = new ConnectedClient(socket);
				client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
