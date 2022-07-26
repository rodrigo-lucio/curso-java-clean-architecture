package br.com.lucio.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.lucio.escola.dominio.Evento;
import br.com.lucio.escola.dominio.Ouvinte;

public class LogAlunoMatriculado extends Ouvinte {

	@Override
	public void reageAo(Evento evento) {
		String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS"));
		System.out.println(String.format("Aluno com CPF %s matriculado em %s", 
				((AlunoMatriculadoEvento) evento).getCpfAluno(),
				momentoFormatado));
	}

    @Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculadoEvento;
	}
	
}
