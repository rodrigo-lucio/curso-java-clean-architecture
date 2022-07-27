package br.com.lucio.escola.academico.dominio.aluno;

import java.util.List;

public interface AlunoRepository {

	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(CPF cpf);
	
	List<Aluno> listarAlunosMatriculados();
}
