package br.com.lucio;

import static java.util.Objects.isNull;

public class Email {

	private String endereco;

	public Email(String endereco) {
		if(isNull(endereco) || 
				!endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail inválido");
		}
		this.endereco = endereco;
	}
	
}
