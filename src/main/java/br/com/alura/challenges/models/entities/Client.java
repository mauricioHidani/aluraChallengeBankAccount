package br.com.alura.challenges.models.entities;

import br.com.alura.challenges.models.enums.AccountType;

import java.util.UUID;

public class Client {

	private final UUID id;
	private final String name;
	private final AccountType type;
	private final double balence;

	public Client(final String name, final AccountType type, final double balence) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.type = type;
		this.balence = balence;
	}

	public Client(final Client newClient, final double balance) {
		this.id = newClient.getId();
		this.name = newClient.getName();
		this.type = newClient.getType();
		this.balence = balance;
	}

	//region Access attributes
	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public AccountType getType() {
		return type;
	}

	public double getBalence() {
		return balence;
	}
	//endregion

	@Override
	public String toString() {
		return
			"""
			***********************************
			Dados iniciais do cliente:
			Nome: %s
			Tipo conta: %s
			Saldo inicial: R$ %.2f
			***********************************
			""".formatted(
				this.name,
				this.type.getValue(),
				this.balence
			)
		;
	}

}
