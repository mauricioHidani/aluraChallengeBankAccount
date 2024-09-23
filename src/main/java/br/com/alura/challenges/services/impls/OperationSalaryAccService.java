package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;

public class OperationSalaryAccService extends OperationService {

	public OperationSalaryAccService(final AppConfig config) {
		super(config);
	}

	@Override
	public double receive(final double amount, final Client client) {
		return client.getBalance() + amount;
	}

	@Override
	public double transfer(final double amount, final Client client) {
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
