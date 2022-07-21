package br.com.lucio.escola.aplicacao.aluno.matricular;

import br.com.lucio.escola.dominio.aluno.Aluno;
import br.com.lucio.escola.dominio.aluno.CPF;
import br.com.lucio.escola.dominio.aluno.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatricularAlunoDTO {

    private String nome;
    private String cpf;
    private String email;

    public Aluno toAluno() {
        return new Aluno(new CPF(this.cpf), this.nome, new Email(this.email));
    }

}
