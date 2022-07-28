package br.com.lucio.escola;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lucio.escola.gamificacao.dominio.selo.Selo;
import br.com.lucio.escola.gamificacao.dominio.selo.SeloRepository;
import br.com.lucio.escola.shared.dominio.CPF;

public class SeloRepositoryMemoryImpl implements SeloRepository {

	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> buscarSelosPorCPF(CPF cpf) {
		return selos.stream()
					.filter(selo -> selo.getCpf().equals(cpf))
					.collect(Collectors.toList());
	}

}
