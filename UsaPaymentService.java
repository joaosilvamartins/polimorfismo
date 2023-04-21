package model.services;

public class UsaPaymentService implements OnlinePaymentService{

	@Override
	public double paymentFee(double amount) {
		return 20;
	}

}
