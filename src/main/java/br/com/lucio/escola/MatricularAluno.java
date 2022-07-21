package br.com.lucio.escola;

import br.com.lucio.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.lucio.escola.aplicacao.aluno.matricular.MatricularAlunoService;
import br.com.lucio.escola.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.infra.aluno.AlunoRepositoryMemoryImpl;

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

        AlunoRepository repository = new AlunoRepositoryMemoryImpl();
        MatricularAlunoService service = new MatricularAlunoService(repository);
        service.executa(dto);

        repository.listarAlunosMatriculados().forEach(a -> System.out.println(a.toString()));

    }

}
