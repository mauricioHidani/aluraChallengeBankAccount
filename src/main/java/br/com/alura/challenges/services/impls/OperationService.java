package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;
import br.com.alura.challenges.services.IOperationService;

public class OperationService implements IOperationService<Client> {

	private final AppConfig config;

	public OperationService(final AppConfig config) {
		this.config = config;
	}

	protected AppConfig getConfig() {
		return this.config;
	}

	@Override
	public double checkBalances(Client client) {
		return client.getBalance();
	}

	@Override
	public double receive(double amount, Client client) {
		return client.getBalance() + amount;
	}

	@Override
	public double transfer(double amount, Client client) {
		return client.getBalance() - amount;
	}

}
