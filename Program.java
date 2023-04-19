package ex.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import ex.entities.Contract;
import ex.entities.Instalment;
import ex.services.ContractService;
import ex.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato: ");
		
		System.out.print("Número: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), dtf);
		
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract c = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ContractService cs = new ContractService(n, c, new PaypalService());
		
		cs.processContract();
		
		System.out.println("Parcelas:");
		
		for(Instalment i : c.getInstalments()) {
			System.out.println(i);
		}
		
		sc.close();
	}

}
