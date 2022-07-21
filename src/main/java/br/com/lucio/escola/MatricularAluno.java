package br.com.lucio.escola;

import br.com.lucio.escola.dominio.aluno.Aluno;
import br.com.lucio.escola.dominio.aluno.AlunoRepository;
import br.com.lucio.escola.dominio.aluno.CPF;
import br.com.lucio.escola.dominio.aluno.Email;
import br.com.lucio.escola.infra.aluno.AlunoRepositoryMemoryImpl;

public class MatricularAluno {

    public static void main(String[] args) {

        String nome = "Rodrigo Lucio";
        CPF cpf = new CPF("31157399070");
        Email email = new Email("luciodigo@gmail.com");
        
        Aluno aluno = new Aluno(cpf, nome, email);
        AlunoRepository repository = new AlunoRepositoryMemoryImpl();
        repository.matricular(aluno);

        aluno.adicionarTelefone("49", "123123123");
        
        repository.listarAlunosMatriculados().forEach(a -> System.out.println(a.toString()));
        
        
        
    }

}
