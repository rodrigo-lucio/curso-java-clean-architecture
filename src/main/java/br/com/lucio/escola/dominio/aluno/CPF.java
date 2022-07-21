package br.com.lucio.escola.dominio.aluno;

import lombok.ToString;

@ToString
public class CPF {

	private String numero;

	public CPF(String numero) {
		if (CpfCnpjValidator.isNotValid(numero)) {
			throw new IllegalArgumentException("CPF invalido");

		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	
}