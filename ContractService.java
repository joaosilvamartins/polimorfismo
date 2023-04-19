package ex.services;

import java.time.LocalDate;

import ex.entities.Contract;
import ex.entities.Instalment;

public class ContractService {
	
	private int months;
	
	private Contract contract;
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(int months, Contract contract, OnlinePaymentService onlinePaymentService) {
		this.months = months;
		this.contract = contract;
		this.onlinePaymentService = onlinePaymentService;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract() {
		double basicValue = contract.getTotalValue() / months;
		
		for(int i=0;i<months;i++) {
			LocalDate d = contract.getDate().plusMonths(i + 1);
			
			double quotaInterest = onlinePaymentService.interest(basicValue, i + 1);
			double quotaFee = onlinePaymentService.paymentFee(basicValue + quotaInterest);
			
			double quotaTotal = basicValue + quotaInterest + quotaFee;
			
			Instalment paymentInstalment = new Instalment(d, quotaTotal);
			contract.getInstalments().add(paymentInstalment);
		}
	}
}
