package primos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		MillerRabinAlgoritmo mr = new MillerRabinAlgoritmo();

		System.out.println("Entre com um numero :\n");
		
		long numero = scan.nextLong();

		boolean primo = mr.isPrimo(numero);
		
		if (primo) {
			System.out.println("\n" + numero + " é primo.");
		}else {
			System.out.println("\n" + numero + " é composto.");
		}

	}

}
