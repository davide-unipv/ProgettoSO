package it.unipv.so.client;

import java.io.IOException;
import java.net.UnknownHostException;

import it.unipv.so.Services;

public class ClientLauncher {

	public ClientLauncher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client c1=new Client();
		Client c2=new Client();
		c1.setMessage(Services.FATTORIALE);
		c2.setMessage(Services.PROVA);
		c2.start();
		c1.start();

	}

}
