package br.com.lucio.escola.academico.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.lucio.escola.academico.dominio.aluno.Aluno;
import br.com.lucio.escola.academico.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.academico.dominio.aluno.CPF;
import br.com.lucio.escola.academico.dominio.aluno.Telefone;

public class AlunoRepositoryJDBCImpl implements AlunoRepository { 
	/* As implementações em infra podem enxergar as partes mais internas do dominio, o que nao pode é ao contrario */
	/* A camada de dominio conversa com as implementações via interface, desacoplando e nao dando problema quando tem alterações */

	private Connection connection;
	
	public AlunoRepositoryJDBCImpl(Connection connection) {
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
			
		    sql = "INSERT INTO telefone (ddd, numero) values (?, ?)";
		    ps = connection.prepareStatement(sql);
		    for(Telefone telefone : aluno.getTelefones()) {
		    	ps.setString(1, telefone.getDdd());
		    	ps.setString(2, telefone.getNumero());
		    	ps.execute();
		    }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		//Implementação buscando por CPF com JDBC
		return null;
	}

	@Override
	public List<Aluno> listarAlunosMatriculados() {
		//Implementação buscando todos com JDBC
		return null;
	}

}
