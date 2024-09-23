package br.com.alura.challenges.services.impls;

import java.util.Scanner;

import br.com.alura.challenges.models.entities.Client;
import br.com.alura.challenges.services.IOperationService;
import br.com.alura.challenges.services.IOperationTrackService;

public class OperationTrackService implements IOperationTrackService<Client> {

	private final IOperationService<Client> operationService;

	public OperationTrackService(final IOperationService<Client> operationService) {
		this.operationService = operationService;
	}

	@Override
	public void onCheckBalances(final Client client) {
        int flag = 1;
        String signal = "";
        double checkBalance = operationService.checkBalances(client);
        if (checkBalance < 0) {
            flag = -1;
            signal = "-";
        }
        System.out.printf(
            """
            Saldo atual: %sR$ %.2f
            -----------------------------------
            
            """,
            signal, (checkBalance * flag)
        );
	}

	@Override
	public Client onReceive(final Client client, final Scanner scanner) {
		System.out.print("Informe o valor a receber: ");
		final double receiveAmount = scanner.nextDouble();
        try {
            final Client result = new Client(
                    client,
                    operationService.receive(receiveAmount, client)
            );
            onLoadBalance(result.getBalance());
            return result;
        }
		catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            return client;
        }

	}

	@Override
	public Client onTransfer(final Client client, final Scanner scanner) {
		System.out.print("Informe o valor que deseja transferir: ");
		final double transferAmount = scanner.nextDouble();

		try {
			final Client result = new Client(
				client,
				operationService.transfer(transferAmount, client)
			);
			onLoadBalance(result.getBalance());
			return result;
		}
		catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

		return client;
	}

	private void onLoadBalance(final double balance) {
        int flag = 1;
        String signal = "";
        if (balance < 0){
           flag = -1;
           signal = "-";
        }
        System.out.printf(
			"""
			Saldo atualizado %sR$ %.2f
			-----------------------------------
                
			""",
			signal, (balance * flag)
        );
	}

}
