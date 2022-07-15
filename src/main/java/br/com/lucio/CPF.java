package br.com.lucio;

public class CPF {

	private String numero;

	public CPF(String numero) {
		if (CpfCnpjValidator.isNotValid(numero)) {
			throw new IllegalArgumentException("CPF invalido");

		}
		this.numero = numero;
	}
}