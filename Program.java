package model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Instalments;
import model.services.BrazilPaymentService;
import model.services.ContractService;
import model.services.UsaPaymentService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato:");
		
		try {
			System.out.print("Número do contrato: ");
			int number = sc.nextInt();
			
			System.out.print("Data do início do contrato (DD/MM/YYYYD): ");
			LocalDate date = LocalDate.parse(sc.next(),dtf);
			
			System.out.print("Valor do contrato: ");
			double totalValue = sc.nextDouble();
			
			Contract c = new Contract(number, date, totalValue);
			
			System.out.println("De qual país é seu contrato? (u/b) ");
			char uORb = sc.next().charAt(0);
			
			if(uORb != 'u' && uORb != 'b') {
				System.out.println("Entrada inválida");
				System.exit(0);
			}
			
			System.out.print("Entre com o número de parcelas: ");
			int n = sc.nextInt();
			
			if(uORb == 'u') {
				ContractService cs = new ContractService(c, new UsaPaymentService(), n);
				cs.processContract();
				
				for(Instalments i : c.getInstalments()) {
					System.out.println(i);
				}
			}
			else if(uORb == 'b') {
				ContractService cs = new ContractService(c, new BrazilPaymentService(), n);
				cs.processContract();
				
				for(Instalments i : c.getInstalments()) {
					System.out.println(i);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Entrada inválida");
		}
		
		sc.close();
	}

}
