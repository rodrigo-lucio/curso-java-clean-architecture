package br.com.lucio.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	private Aluno aluno;
	
	@BeforeEach
	void setUp() {
		this.aluno = new Aluno(new CPF("94679337052"), "João do teste", new Email("joao@joao.com.br"));
	}

	@Test
	void devePermitirAdicionar1Telefone() {
		String ddd = "49";
		String numero = "91123456";
		Telefone telefone = new Telefone(ddd, numero);
		this.aluno.adicionarTelefone(ddd, numero);
		assertEquals(this.aluno.getTelefones().get(0), telefone);
		assertEquals(this.aluno.getTelefones().size(), 1);
	}
	
	@Test
	void devePermitirAdicionar2Telefones() {
		String ddd = "49";
		String numero = "91123456";
		Telefone telefone = new Telefone(ddd, numero);
		this.aluno.adicionarTelefone(ddd, numero);
		
		String ddd2 = "49";
		String numero2 = "81123456";
		Telefone telefone2 = new Telefone(ddd2, numero2);
		this.aluno.adicionarTelefone(ddd2, numero2);
		
		assertEquals(this.aluno.getTelefones().get(0), telefone);
		assertEquals(this.aluno.getTelefones().get(1), telefone2);
		assertEquals(this.aluno.getTelefones().size(), 2);
	}
	
	@Test
	void naoDevePermitirAdicionar3Telefones() {
		String ddd = "49";
		String numero = "91123456";
		Telefone telefone = new Telefone(ddd, numero);
		this.aluno.adicionarTelefone(ddd, numero);
		
		String ddd2 = "49";
		String numero2 = "81123456";
		Telefone telefone2 = new Telefone(ddd2, numero2);
		this.aluno.adicionarTelefone(ddd2, numero2);
		
		
		String ddd3 = "49";
		String numero3 = "81123456";
		Telefone telefone3 = new Telefone(ddd3, numero3);
		
		assertThrows(IllegalArgumentException.class, () -> this.aluno.adicionarTelefone(ddd2, numero2));
		assertEquals(this.aluno.getTelefones().get(0), telefone);
		assertEquals(this.aluno.getTelefones().get(1), telefone2);
		assertEquals(this.aluno.getTelefones().size(), 2);
		
	}
	
	

}
