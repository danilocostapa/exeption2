package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Conta;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		
		System.out.print("Numero: ");
		int numero = entrada.nextInt();
		
		System.out.print("Títular da conta: ");
		entrada.nextLine();
		String titular = entrada.nextLine();
		
		System.out.print("Saldo inicial: ");
		double saldo = entrada.nextDouble();
		
		System.out.print("Limite de saque: ");
		double limiteSaque = entrada.nextDouble();
		
		Conta conta = new Conta(numero, titular, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("informe uma quantia para sacar: ");
		double valor = entrada.nextDouble();
		
		conta.saque(valor);
		try {
			
			System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		entrada.close();
	}

}
