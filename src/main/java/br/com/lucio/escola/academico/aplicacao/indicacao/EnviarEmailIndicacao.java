package br.com.lucio.escola.academico.aplicacao.indicacao;

import br.com.lucio.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno aluno);

}
