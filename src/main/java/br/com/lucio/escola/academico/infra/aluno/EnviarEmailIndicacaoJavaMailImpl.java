package br.com.lucio.escola.academico.infra.aluno;

import br.com.lucio.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.lucio.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMailImpl implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno aluno) {
		System.out.println("Enviando email para " + aluno.getEmail());
	}

}
