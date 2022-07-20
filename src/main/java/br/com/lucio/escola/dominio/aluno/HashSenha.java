package br.com.lucio.escola.dominio.aluno;

public interface HashSenha {

	String criarHashSenha(String senha);

	boolean isSenhaValida(String senhaHash, String senhaDigitada);
	
}
