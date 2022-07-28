package br.com.lucio.escola.academico;

import br.com.lucio.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.lucio.escola.academico.aplicacao.aluno.matricular.MatricularAlunoService;
import br.com.lucio.escola.academico.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.academico.dominio.aluno.EnviaEmailAlunoMatriculado;
import br.com.lucio.escola.academico.dominio.aluno.LogAlunoMatriculado;
import br.com.lucio.escola.academico.infra.aluno.AlunoRepositoryMemoryImpl;
import br.com.lucio.escola.shared.dominio.evento.PublicadorEventos;

public class MatricularAluno {

    public static void main(String[] args) {

        //Dados que vem da linha de comando, json, formulario WEB....
        String nome = "Rodrigo Lucio";
        String cpf = "31157399070";
        String email = "luciodigo@gmail.com";

        MatricularAlunoDTO dto = MatricularAlunoDTO.builder() //
                .nome(nome) //
                .cpf(cpf) //
                .email(email) //
                .build(); //
        
        PublicadorEventos publicador = new PublicadorEventos();
        publicador.adicionarOuvinte(new LogAlunoMatriculado());
        publicador.adicionarOuvinte(new EnviaEmailAlunoMatriculado());

        AlunoRepository repository = new AlunoRepositoryMemoryImpl();
        MatricularAlunoService service = new MatricularAlunoService(repository, publicador);
        service.executa(dto.toAluno());

        repository.listarAlunosMatriculados().forEach(a -> System.out.println(a.toString()));

    }

}
