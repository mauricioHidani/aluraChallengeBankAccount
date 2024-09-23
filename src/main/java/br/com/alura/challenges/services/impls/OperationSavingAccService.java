package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;

public class OperationSavingAccService extends OperationService {

	public OperationSavingAccService(AppConfig config) {
		super(config);
	}

	@Override
	public double receive(double amount, Client client) {
        if(amount < 0) {
			throw new IllegalArgumentException("Valor de recebimento não pode ser negativo");
		}
        return client.getBalance() + amount;
	}

	@Override
	public double transfer(double amount, Client client) {
		if (client.getBalance() >= amount) {
			return client.getBalance() - amount;
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
