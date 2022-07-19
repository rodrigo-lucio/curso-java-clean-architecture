package br.com.lucio.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.lucio.escola.dominio.aluno.Aluno;
import br.com.lucio.escola.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.dominio.aluno.CPF;

public class AlunoRepositoryJDBC implements AlunoRepository {

	private Connection connection;
	
	public AlunoRepositoryJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			String sql = "INSERT INTO aluno (cpf, nome, email) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf().getNumero());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail().getEndereco());
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		return null;
	}

	@Override
	public List<Aluno> listarAlunosMatriculados() {
		return null;
	}

}
