package br.com.lucio;

import static java.util.Objects.isNull;

import java.util.Objects;

public class Telefone {

	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;

		if (Objects.isNull(ddd) || isNull(numero)) {
			throw new IllegalArgumentException("DDD e Número são obrigatórios");
		}

		if (!ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD inválido");
		}

		if (!numero.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("Número inválido");
		}

	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
