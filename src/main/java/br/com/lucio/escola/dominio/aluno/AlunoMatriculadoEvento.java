package br.com.lucio.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.lucio.escola.dominio.Evento;

public class AlunoMatriculadoEvento implements Evento {

	private final CPF cpfAluno;
	private final LocalDateTime momento;
	
	public AlunoMatriculadoEvento(CPF cpfAluno) {
		this.cpfAluno = cpfAluno;
		this.momento = LocalDateTime.now();
	}

	public CPF getCpfAluno() {
		return cpfAluno;
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

}
