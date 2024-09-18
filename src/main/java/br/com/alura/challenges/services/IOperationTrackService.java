package br.com.alura.challenges.services;

import java.util.Scanner;

public interface IOperationTrackService<CLIENT> {

	void onCheckBalances(CLIENT client);
	CLIENT onReceive(CLIENT client, Scanner scanner);
	CLIENT onTransfer(CLIENT client, Scanner scanner);

}
