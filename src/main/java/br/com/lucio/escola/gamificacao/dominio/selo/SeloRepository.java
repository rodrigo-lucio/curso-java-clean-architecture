package br.com.lucio.escola.gamificacao.dominio.selo;

import java.util.List;

import br.com.lucio.escola.shared.dominio.CPF;

public interface SeloRepository {

	void adicionar(Selo selo);
	
	List<Selo> buscarSelosPorCPF(CPF cpf);
}
