package br.com.alura.challenges.models.enums;

public enum OperationType {

	START(0),
	CONSULT_BALANCE(1),
	RECEIVE_AMOUNT(2),
	TRANSFER_AMOUNT(3),
	EXIT(4),
	INVALID(-1);

	private int value;

	OperationType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
