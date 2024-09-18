package br.com.alura.challenges;

import br.com.alura.challenges.controllers.BankAccount;
import br.com.alura.challenges.models.entities.Client;
import br.com.alura.challenges.models.enums.AccountType;

public class Main {
	public static void main(String[] args) {
		Client clientNathalia = new Client(
			"Nathalia Albuquerque",
			AccountType.CURRENT,
			12790d
		);
		Client clientJacqueline = new Client(
			"Jacqueline Oliveira",
			AccountType.SALARY,
			2500d
		);
		Client clientAna = new Client(
			"Ana Jablonsky",
			AccountType.SAVINGS,
			60900d
		);

		BankAccount.of(clientNathalia).start();
	}
}