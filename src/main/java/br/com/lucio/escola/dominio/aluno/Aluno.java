package br.com.lucio.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.ToString;

@ToString
public class Aluno {

	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha; 

	public void adicionarTelefone(String ddd, String numero) {
		if(this.telefones.size() == 2) {
			throw new IllegalArgumentException("Só pode ser cadastrado dois telefones por aluno");
		}
		
		this.telefones.add(new Telefone(ddd, numero));
	}

	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Email getEmail() {
		return email;
	}

	public List<Telefone> getTelefones() {
		return Collections.unmodifiableList(this.telefones);
	}
	
}
