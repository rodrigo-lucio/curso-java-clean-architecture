package br.com.lucio.escola.aplicacao.aluno.matricular;

import br.com.lucio.escola.dominio.aluno.Aluno;
import br.com.lucio.escola.dominio.aluno.AlunoRepository;

public class MatricularAlunoService {

    private AlunoRepository repository;

    public MatricularAlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    //Pattern Command
    public void executa(Aluno aluno) {
        repository.matricular(aluno);
    }
    
}
