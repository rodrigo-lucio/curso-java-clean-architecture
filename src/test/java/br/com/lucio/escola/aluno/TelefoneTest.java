package br.com.lucio.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.lucio.escola.aluno.Telefone;

class TelefoneTest {

	@Test
	void naoDeveCriarTelefoneComDDDENumeroInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "33332222"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "33332222"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "333322222"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", "1333322222"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("11", "22"));
	}

	@Test
	void deveCriarTelefonesValidos() {
		String ddd = "11";
		String numero = "133322222";
		Telefone telefone1 = assertDoesNotThrow(() -> new Telefone(ddd, numero));
		assertEquals(ddd, telefone1.getDdd());
		assertEquals(numero, telefone1.getNumero());
		
		String numero2 = "333222222";
		Telefone telefone2 = assertDoesNotThrow(() -> new Telefone(ddd, numero2));
		assertEquals(ddd, telefone2.getDdd());
		assertEquals(numero2, telefone2.getNumero());
	}

}
