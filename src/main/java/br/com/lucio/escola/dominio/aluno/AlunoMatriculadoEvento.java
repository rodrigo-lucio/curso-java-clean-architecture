package br.com.lucio.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.lucio.escola.dominio.Evento;

public class AlunoMatriculadoEvento implements Evento {

	private final CPF cpfAluno;
	private final Email emailAluno;
	private final LocalDateTime momento;
	
	public AlunoMatriculadoEvento(CPF cpfAluno, Email emailAluno) {
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
		this.momento = LocalDateTime.now();
	}

	public CPF getCpfAluno() {
		return cpfAluno;
	}
	
	
	public Email getEmailAluno() {
		return emailAluno;
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

}
