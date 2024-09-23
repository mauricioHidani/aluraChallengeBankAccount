package br.com.alura.challenges.controllers;

import br.com.alura.challenges.configs.AppConfig;
import br.com.alura.challenges.models.entities.Client;
import br.com.alura.challenges.models.enums.AccountType;
import br.com.alura.challenges.models.enums.OperationType;
import br.com.alura.challenges.services.IOperationService;
import br.com.alura.challenges.services.impls.OperationCurrentAccService;
import br.com.alura.challenges.services.impls.OperationSalaryAccService;
import br.com.alura.challenges.services.impls.OperationSavingAccService;
import br.com.alura.challenges.services.impls.OperationTrackService;

import java.util.Scanner;

public class BankAccount {

	private static BankAccount instance;

	private final Scanner scanner = new Scanner(System.in);
	private final AppConfig config = new AppConfig();
	private final Operations operations = new Operations();

	private Client client;
	private IOperationService<Client> operationService;
	private OperationTrackService trackService;

	private BankAccount() {
	}

	public static BankAccount of(final Client client) {
		if (instance == null) {
			instance = new BankAccount();
			instance.client = client;
			startOperations();
		}
		return instance;
	}

	public void start() {
		OperationType operation = OperationType.START;

		System.out.println(operations.bannerSrc());
		System.out.println(client);
		while (operation != OperationType.EXIT) {
			operation = onChoiceOperation();
		}
	}

	protected OperationType onChoiceOperation() {
		System.out.println(operations.operationsSrc());
		System.out.print("Digite a opção desejada: ");
		OperationType operationType = operations.getOperation(scanner);

		switch (operationType) {
			case OperationType.CONSULT_BALANCE -> trackService.onCheckBalances(client);
			case OperationType.RECEIVE_AMOUNT  -> client = trackService.onReceive(client, scanner);
			case OperationType.TRANSFER_AMOUNT -> client = trackService.onTransfer(client, scanner);
			case OperationType.EXIT            -> exitOperation();
			default                            -> invalidOperation();
		}

		return operationType;
	}

	private static void startOperations() {
		switch (instance.client.getType()) {
			case AccountType.CURRENT -> instance.operationService = new OperationCurrentAccService(instance.config);
			case AccountType.SAVINGS -> instance.operationService = new OperationSavingAccService(instance.config);
			case AccountType.SALARY  -> instance.operationService = new OperationSalaryAccService(instance.config);
		}
		instance.trackService = new OperationTrackService(instance.operationService);
	}

	private void exitOperation() {
		System.out.println("Operação finalizada!");
	}

	private void invalidOperation() {
		System.out.print(
			"""
			Operação inválida!
			-----------------------------------
			
			"""
		);
	}

}
