package it.unipv.so;



import java.io.IOException;
import java.net.UnknownHostException;

import it.unipv.so.client.Client;
import it.unipv.so.server.Server;

public class Tester {

	public Tester() {
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 8888;
        Server server = new Server(port);
        server.start();
      
		for(int i=0;i<13;i++){
			Client c=new Client();
			c.connectToServer(i+"");
		}
        

	}

}
