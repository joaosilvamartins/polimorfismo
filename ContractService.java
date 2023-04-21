package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Instalments;

public class ContractService {

	private Contract c;
	
	private OnlinePaymentService onlinePaymentService;
	
	private int months;

	public ContractService(Contract c, OnlinePaymentService onlinePaymentService, int months) {
		this.c = c;
		this.onlinePaymentService = onlinePaymentService;
		this.months = months;
	}

	public Contract getC() {
		return c;
	}

	public void setC(Contract c) {
		this.c = c;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public void processContract() {
		double basicValue = c.getTotalValue() / months;
		
		for(int i=0;i<getMonths();i++) {
			LocalDate d = c.getDate().plusMonths(i + 1);
			
			double valueInterest = onlinePaymentService.interest(basicValue, i + 1);
			double valuePayment = onlinePaymentService.paymentFee(valueInterest);
			
			double valueTotal = basicValue + valueInterest + valuePayment;
			
			c.getInstalments().add(new Instalments(d,valueTotal));
		}
	}
}
