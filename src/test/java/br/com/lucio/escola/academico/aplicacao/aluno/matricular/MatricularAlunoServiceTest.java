package br.com.lucio.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.lucio.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.lucio.escola.academico.aplicacao.aluno.matricular.MatricularAlunoService;
import br.com.lucio.escola.academico.dominio.aluno.Aluno;
import br.com.lucio.escola.academico.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.shared.dominio.evento.Evento;
import br.com.lucio.escola.shared.dominio.evento.PublicadorEventos;

@ExtendWith(MockitoExtension.class)
class MatricularAlunoServiceTest {

	@InjectMocks
	private MatricularAlunoService service;

	@Mock
	private AlunoRepository alunoRepository;

	@Mock
	private PublicadorEventos publicadorEventos;

	private MatricularAlunoDTO dto;

	@BeforeEach
	void setUp() {
		dto = MatricularAlunoDTO.builder() //
				.nome("Rodrigo Lúcio") //
				.cpf("31157399070") //
				.email("luciodigo@gmail.com") //
				.build(); //
	}

	@Test
	void alunoDeveSerPersistido() {
		Aluno aluno = dto.toAluno();
		assertDoesNotThrow(() -> service.executa(aluno));
		verify(alunoRepository).matricular(aluno);
		verify(publicadorEventos).publicar(any(Evento.class));
	}

}
