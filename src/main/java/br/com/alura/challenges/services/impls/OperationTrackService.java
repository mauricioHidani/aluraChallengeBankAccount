package br.com.alura.challenges.services.impls;

import br.com.alura.challenges.models.entities.Client;
import br.com.alura.challenges.services.IOperationService;
import br.com.alura.challenges.services.IOperationTrackService;

import java.util.Scanner;

public class OperationTrackService implements IOperationTrackService<Client> {

	private final IOperationService<Client> operationService;

	public OperationTrackService(IOperationService<Client> operationService) {
		this.operationService = operationService;
	}

	@Override
	public void onCheckBalances(Client client) {
		if (operationService.checkBalances(client) > 0) {
			System.out.printf(
				"""
				Saldo atual: R$ %.2f
				-----------------------------------
				
				""",
				operationService.checkBalances(client)
			);
			return;
		}

		System.out.printf(
			"""
			Saldo atual: -R$ %.2f
			-----------------------------------
			
			""",
			(operationService.checkBalances(client) * -1)
		);
	}

	@Override
	public Client onReceive(Client client, Scanner scanner) {
		System.out.print("Informe o valor a receber: ");
		final double receiveAmount = scanner.nextDouble();
        try {
            final Client result = new Client(
                    client,
                    operationService.receive(receiveAmount, client)
            );
            onLoadBalance(result.getBalance());
            return result;
        }catch(IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            return client;
        }

	}

	@Override
	public Client onTransfer(Client client, Scanner scanner) {
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
		if (balance > 0) {
			System.out.printf(
				"""
				Saldo atualizado R$ %.2f
				-----------------------------------
				
				""",
				balance
			);
			return;
		}

		System.out.printf(
			"""
			Saldo atualizado -R$ %.2f
			-----------------------------------
			
			""",
			(balance * -1)
		);
	}

}
