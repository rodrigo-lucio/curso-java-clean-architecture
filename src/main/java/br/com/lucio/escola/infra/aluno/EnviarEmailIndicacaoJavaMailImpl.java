package br.com.lucio.escola.infra.aluno;

import br.com.lucio.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.lucio.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMailImpl implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno aluno) {
		System.out.println("Enviando email para " + aluno.getEmail());
	}

}
