package br.com.lucio.escola.aplicacao.aluno.matricular;

import br.com.lucio.escola.dominio.PublicadorEventos;
import br.com.lucio.escola.dominio.aluno.Aluno;
import br.com.lucio.escola.dominio.aluno.AlunoMatriculadoEvento;
import br.com.lucio.escola.dominio.aluno.AlunoRepository;

public class MatricularAlunoService {

    private AlunoRepository repository;
    
    private PublicadorEventos publicadorEventos;

    public MatricularAlunoService(AlunoRepository repository, PublicadorEventos publicadorEventos) {
        this.repository = repository;
		this.publicadorEventos = publicadorEventos;
    }

    //Pattern Command
    public void executa(Aluno aluno) {
        repository.matricular(aluno);
        AlunoMatriculadoEvento evento = new AlunoMatriculadoEvento(aluno.getCpf(), aluno.getEmail());
        publicadorEventos.publicar(evento);
    }
    
}
