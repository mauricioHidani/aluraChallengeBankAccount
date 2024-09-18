package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;

public class OperationCurrentAccService extends OperationService {

	public OperationCurrentAccService(AppConfig config) {
		super(config);
	}

	@Override
	public double receive(double amount, Client client) {
		return client.getBalence() + amount;
	}

	@Override
	public double transfer(double amount, Client client) {
		final double feeResult = getConfig().getTransferFee();
		final double overdraftResult = (amount + feeResult) * getConfig().getOverdraftRate();

		if (client.getBalence() > (amount + feeResult)) {
			return client.getBalence() - amount - feeResult;
		}
		return client.getBalence() - amount - feeResult - overdraftResult;
	}

}
