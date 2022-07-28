package br.com.lucio.escola.academico.dominio.aluno;

import br.com.lucio.escola.shared.dominio.evento.Evento;
import br.com.lucio.escola.shared.dominio.evento.Ouvinte;

public class EnviaEmailAlunoMatriculado extends Ouvinte {

	@Override
	public void reageAo(Evento evento) {
		System.out.println("Enviando email para o aluno matriculado: " + ((AlunoMatriculadoEvento) evento).getEmailAluno());
	}

    @Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculadoEvento;
	}
	
}
