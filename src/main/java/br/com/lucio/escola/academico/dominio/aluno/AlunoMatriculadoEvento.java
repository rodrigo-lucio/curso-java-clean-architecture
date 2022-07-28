package br.com.lucio.escola.academico.dominio.aluno;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.lucio.escola.shared.dominio.CPF;
import br.com.lucio.escola.shared.dominio.evento.Evento;
import br.com.lucio.escola.shared.dominio.evento.TipoEvento;

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

	@Override
	public TipoEvento tipo() {
		return TipoEvento.ALUNO_MATRICULADO;
	}

	@Override
	public Map<String, Object> informacoes() {
		return Map.of("CPF", this.cpfAluno);
	}

}
