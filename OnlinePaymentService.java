package model.services;

import java.security.InvalidParameterException;

public interface OnlinePaymentService {

	default double interest(double amount, int months) {
		if(months < 1) {
			throw new InvalidParameterException("Erro: número de meses menor que 1");
		}
		return amount * 0.01 * months;
	}
	double paymentFee(double amount);
}
