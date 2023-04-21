package model.entities;

import java.time.LocalDate;

public class Instalments {
	
	private LocalDate date;
	
	private double amount;

	public Instalments(LocalDate date, double amount) {
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
		return getDate() + " - R$" + String.format("%.2f", amount);
	}
	
}
