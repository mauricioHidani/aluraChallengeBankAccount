package br.com.alura.challenges.configs;

public class AppConfig {

	private final float TRANSFER_FEE = 0.12f;
	private final float OVERDRAFT_RATE = 0.30f;

	public float getTransferFee() {
		return this.TRANSFER_FEE;
	}

	public float getOverdraftRate() {
		return this.OVERDRAFT_RATE;
	}

}
