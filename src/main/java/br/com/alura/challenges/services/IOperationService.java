package br.com.alura.challenges.services;

public interface IOperationService<CLIENT> {

	double checkBalances(CLIENT client);
	double receive(double amount, CLIENT client);
	double transfer(double amount, CLIENT client);

}
