package teste;

import java.util.Scanner;

/*
 * assinatura R$23.32
 * LIGACAO LOCAL 0,09/MIN
 * DDD 0,23/MIN
 * DDI 0,86/MIN
 * 
 * */

public class ContaTelefonica {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("digite os minutos de ligação local usados");
		double assinatura = 23.32;
		double ligaçãolocal = scan.nextDouble();
		System.out.println("Digite os minutos gastos de ligação de DDD ");
		double DDD = scan.nextDouble();
		System.out.println("Digite os minutos gastos de ligação de DDI ");
		double DDI = scan.nextDouble();
		double total = ((ligaçãolocal * 0.09) + (DDD * 0.23) + (DDI * 0.86) + assinatura);
		System.out.println("O valor total da sua conta foi :" + total);

	}

}
