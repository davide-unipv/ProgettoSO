package it.unipv.so.server.operations;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public static String fibb(int count) {
		int n1=0,n2=1,n3,i;  
		String result;
		result=n1+" "+n2; //printing 0 and 1  
		  
		for(i=2;i<count;++i) { //loop starts from 2 because 0 and 1 are already printed  
			n3=n1+n2;  
		    result+=" "+n3;  
		    n1=n2;  
		    n2=n3;
		 }  
		 return result;
	}

}
