package br.com.lucio.escola.aplicacao.indicacao;

import br.com.lucio.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno aluno);

}
