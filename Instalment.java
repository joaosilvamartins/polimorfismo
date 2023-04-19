package ex.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Instalment {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate date;
	private double amount;
	
	public Instalment(LocalDate date, double amount) {
		this.date = date;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return dtf.format(date) + " - " + amount;
	}
	
}
