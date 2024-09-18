package br.com.alura.challenges.controllers;

import java.util.Scanner;

import br.com.alura.challenges.models.enums.OperationType;

public class Operations {

	protected String operationsSrc() {
		return (
   			"""
			Operações
		   
			1- Consultar saldos
			2- Receber valor
			3- Transferir valor
			4- Sair
			"""
		);
	}

	public OperationType getOperation(Scanner scanner) {
		final int choice = scanner.nextInt();
		if (choice > 0 && choice < (OperationType.values().length -1)) {
			return OperationType.values()[choice];
		}
		return OperationType.INVALID;
	}

}
