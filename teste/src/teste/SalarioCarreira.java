package teste;

import java.util.Scanner;

public class SalarioCarreira {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite seu nome");
		String nome = scan.nextLine();
		System.out.println("digite seu nivel na empresa de 1 a 5 ");
		int nivel = scan.nextInt();
		System.out.println("digite suas horas trabalhadas");
		int hrstrab = scan.nextInt();

		if (nivel == 1) {
			System.out.println(" O funcionário" + nome + "trabalhou" + hrstrab + "horas por R$" + 15
					+ "(nivel do funcionario " + nivel + ") E deve receber");
			System.out.println(" R$ " + 15 * hrstrab);

		}
		if (nivel == 2) {
			System.out.println(" O funcionário" + nome + "trabalhou" + hrstrab + "horas por R$" + 15
					+ "(nivel do funcionario " + nivel + ") E deve receber");
			System.out.println(" R$ " + 18 * hrstrab);

		}
		if (nivel == 3) {
			System.out.println(" O funcionário" + nome + "trabalhou" + hrstrab + "horas por R$" + 15
					+ "(nivel do funcionario " + nivel + ") E deve receber");
			System.out.println(" R$ " + 22 * hrstrab);

		}
		if (nivel == 4) {
			System.out.println(" O funcionário" + nome + "trabalhou" + hrstrab + "horas por R$" + 15
					+ "(nivel do funcionario " + nivel + ") E deve receber");
			System.out.println(" R$ " + 27 * hrstrab);

		}
		if (nivel == 5) {
			System.out.println(" O funcionário " + nome + "trabalhou" + hrstrab + "horas por R$" + 15
					+ " (nivel do funcionario " + nivel + ")E deve receber");
			System.out.println(" R$ " + 33 * hrstrab);

		}

	}
}
