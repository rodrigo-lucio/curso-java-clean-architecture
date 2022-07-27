package br.com.lucio.escola.gamificacao.dominio.selo;

import br.com.lucio.escola.shared.dominio.CPF;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Selo {

	private CPF cpf;
	private String nome;

}
