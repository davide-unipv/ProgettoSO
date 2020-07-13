package it.unipv.so.old.server;

public class ServerLauncher {

	public ServerLauncher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int port = 8888;
        Server server = new Server(port);
        server.start();

	}

}
