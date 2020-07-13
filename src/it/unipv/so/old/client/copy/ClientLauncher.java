package it.unipv.so.old.client.copy;

import java.io.IOException;
import java.net.UnknownHostException;

import it.unipv.so.old.Services;

public class ClientLauncher {

	public ClientLauncher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client c1=new Client();
		Client c2=new Client();
		String ris;
		ris=c1.notifyServer((String.valueOf(Services.FATTORIALE)+"/"+25));
		System.out.println(ris);
		ris=c2.notifyServer((String.valueOf(Services.FIBONACCI)+"/"+1));
		System.out.println(ris);
		
	}

}
