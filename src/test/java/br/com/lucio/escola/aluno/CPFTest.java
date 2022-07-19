package br.com.lucio.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.lucio.escola.aluno.CPF;

class CPFTest {

	@Test
	void naoDeveCriarCpfComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("12312312321"));
	}

	@Test
	void deveCriarCpfComNumerosValidos() {
		assertDoesNotThrow(() -> new CPF("07380021001"));
		assertDoesNotThrow(() -> new CPF("67238202077"));
		assertDoesNotThrow(() -> new CPF("97432035083"));
		assertDoesNotThrow(() -> new CPF("78638789009"));
		assertDoesNotThrow(() -> new CPF("63434345000"));
	}


}
