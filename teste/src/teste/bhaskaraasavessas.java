package teste;

import java.util.Scanner;

public class bhaskaraasavessas {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("valor da primeira raiz: ");
		int raiz1 = scan.nextInt();
		System.out.println("valor da segunda raiz: ");
		int raiz2 = scan.nextInt();
		System.out.println("valor do eixo y (coeficiente c): ");
		int c = scan.nextInt();

		int multiplicaRaiz = raiz1 * raiz2;

		int somaRaiz = raiz1 + raiz2;
		int a = c / multiplicaRaiz;

		int b = (a * somaRaiz) * -1;
		System.out.println("valor de a: " + a + " Valor de b: " + b + " Valor de c: " + c);

	}

}
