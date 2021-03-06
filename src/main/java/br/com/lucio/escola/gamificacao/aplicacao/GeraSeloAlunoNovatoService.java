package br.com.lucio.escola.gamificacao.aplicacao;

import br.com.lucio.escola.gamificacao.dominio.selo.Selo;
import br.com.lucio.escola.gamificacao.dominio.selo.SeloRepository;
import br.com.lucio.escola.shared.dominio.CPF;
import br.com.lucio.escola.shared.dominio.evento.Evento;
import br.com.lucio.escola.shared.dominio.evento.Ouvinte;
import br.com.lucio.escola.shared.dominio.evento.TipoEvento;

public class GeraSeloAlunoNovatoService extends Ouvinte {

	private SeloRepository seloRepository; 
	
	public GeraSeloAlunoNovatoService(SeloRepository seloRepository) {
		this.seloRepository = seloRepository;
	}

	@Override
	protected void reageAo(Evento evento) {
		/* Fizemos dessa forma, para nao acessar informaçoes de AlunoMatriculadoEvento, 
		 * que esta no modulo: br.com.lucio.escola.academico \
		 * Já CPF esta no contexto compartilhado */
		CPF cpfAluno = (CPF) evento.informacoes().get("CPF"); 
		Selo seloNovato = new Selo(cpfAluno, "Novato");
		seloRepository.adicionar(seloNovato);
		System.out.println("Gerando selo para aluno novato:" + cpfAluno);
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoEvento.ALUNO_MATRICULADO;
	}

}
