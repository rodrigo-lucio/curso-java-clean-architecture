package br.com.lucio.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.lucio.escola.academico.dominio.aluno.Aluno;
import br.com.lucio.escola.academico.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.shared.dominio.CPF;

public class AlunoRepositoryMemoryImpl implements AlunoRepository {

	private List<Aluno> matriculados = new ArrayList<>();

	@Override
	public void matricular(Aluno aluno) {
		matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		return matriculados.stream() //
				.filter(aluno -> aluno.getCpf().equals(cpf)) //
				.findFirst() //
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	}

	@Override
	public List<Aluno> listarAlunosMatriculados() {
		return matriculados;
	}

}
