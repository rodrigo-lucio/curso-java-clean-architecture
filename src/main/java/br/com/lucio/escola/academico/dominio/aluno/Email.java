package br.com.lucio.escola.academico.dominio.aluno;

import static java.util.Objects.isNull;

import lombok.ToString;

@ToString
public class Email {

	private String endereco;

	public Email(String endereco) {
		if(isNull(endereco) || 
				!endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail inválido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return endereco;
	}
	
	
	
}
