package polimorfismo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Programa {

	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'c') {
				Product p = new Product(name, price);
				list.add(p);
			}
			else if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				Product p = new ImportedProduct(name, price, customsFee);
				list.add(p);
			}
			else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				
				Product p = new UsedProduct(name, price, manufactureDate);
				list.add(p);
			}
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS:");
		for(Product p : list) {
			System.out.println(p);
		}
		
		sc.close();
	}

}
