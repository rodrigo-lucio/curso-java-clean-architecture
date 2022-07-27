package br.com.lucio.escola.academico.aluno;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.lucio.escola.academico.dominio.aluno.Email;

class EmailTest {

	@Test
	void naoDeveCriarEmailComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email("blabla"));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
	}

	@Test
	void deveCriarEmailComEnderecosValidos() {
		assertDoesNotThrow(() -> new Email("luciodigo@gmail.com"));
		assertDoesNotThrow(() -> new Email("luciodigo@gmail.com.br"));
		assertDoesNotThrow(() -> new Email("luciodigo@gmail.br"));
		assertDoesNotThrow(() -> new Email("luciodigo@gmail.gov.br"));
		assertDoesNotThrow(() -> new Email("luciodigo@lucio.com.br"));
		assertDoesNotThrow(() -> new Email("luciodigo@lucio.net.br"));
	}

}
