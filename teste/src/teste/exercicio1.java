package teste;

import java.util.Random;
import java.util.Scanner;

public class exercicio1 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		 
		System.out.println(" ");
	    
		 Random randomizer = new Random ();
		 int x = randomizer.nextInt(10);
		System.out.println(x); 
		//int x = scan.nextInt();
		 //int y = scan.nextInt();
		 int y = randomizer.nextInt(10);
		 System.out.println(y);
	    int R = (x+y);
	    if (R < 10 ){
	    	System.out.println("imprima o numero" +R);
	}else{
		System.out.println("valor maior que 10");
		
	}
	    
	  System.out.println(+R);
	  
		
	}

}