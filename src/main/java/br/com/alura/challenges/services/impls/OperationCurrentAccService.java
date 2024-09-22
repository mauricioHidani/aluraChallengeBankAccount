package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;

public class OperationCurrentAccService extends OperationService {

	public OperationCurrentAccService(AppConfig config) {
		super(config);
	}

	@Override
	public double receive(double amount, Client client) {
        if(amount < 0)
            throw new IllegalArgumentException("Valor de recebimento não pode ser negativo");
		return client.getBalance() + amount;
	}

	@Override
	public double transfer(double amount, Client client) {
		final double feeResult = getConfig().getTransferFee();
		final double overdraftResult = (amount + feeResult) * getConfig().getOverdraftRate();

		if (client.getBalence() > (amount + feeResult)) {
			return client.getBalence() - amount - feeResult;
		if (client.getBalance() > (amount + feeResult)) {
			return client.getBalance() - amount - feeResult;
		}
		return client.getBalance() - amount - feeResult - overdraftResult;
	}

}
