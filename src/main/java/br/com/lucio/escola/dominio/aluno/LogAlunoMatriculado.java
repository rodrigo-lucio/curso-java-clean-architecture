package br.com.lucio.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

public class LogAlunoMatriculado {

	public void reageAo(AlunoMatriculadoEvento evento) {
		String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/aaaa HH:mm:ss"));
		System.out.println(String.format("Aluno com CPF %s matriculado em %s", 
				evento.getCpfAluno().getNumero(),
				momentoFormatado));
	}
	
}
