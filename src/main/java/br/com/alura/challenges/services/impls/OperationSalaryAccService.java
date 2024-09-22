package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;

public class OperationSalaryAccService extends OperationService {

	public OperationSalaryAccService(AppConfig config) {
		super(config);
	}

	@Override
	public double receive(double amount, Client client) {
		return client.getBalance() + amount;
	}

	@Override
	public double transfer(double amount, Client client) {
		final double feeResult = getConfig().getTransferFee() * amount;

		if (client.getBalance() > (amount + feeResult)) {
			return client.getBalance() - amount - feeResult;
		}
		throw new RuntimeException(
			"""
			%s seu saldo é insuficiente para realizar a operação!
			Saldo: R$ %.2f
			""".formatted(
				client.getName(),
				client.getBalance()
			)
		);
	}

}
