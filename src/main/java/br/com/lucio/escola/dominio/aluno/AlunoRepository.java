package br.com.lucio.escola.dominio.aluno;

import java.util.List;

public interface AlunoRepository {

	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(CPF cpf);
	
	List<Aluno> listarAlunosMatriculados();
}
