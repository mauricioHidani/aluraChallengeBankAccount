package br.com.alura.challenges.models.enums;

public enum AccountType {

	CURRENT("Corrente"),
	SAVINGS("Poupança"),
	SALARY("Salário");

	private final String value;

	AccountType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
