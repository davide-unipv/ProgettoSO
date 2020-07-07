package it.unipv.so.server.operations;

public class Fattoriale {

	public static int fattoriale(int n) {
		if (n == 0)
			return 1;
		else 
		{
			return n * fattoriale(n - 1); // R: rientro del metodo fattoriale
		}
	}
}