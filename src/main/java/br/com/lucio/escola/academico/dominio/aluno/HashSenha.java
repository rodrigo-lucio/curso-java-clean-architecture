package br.com.lucio.escola.academico.dominio.aluno;

public interface HashSenha {

	String criarHashSenha(String senha);

	boolean isSenhaValida(String senhaHash, String senhaDigitada);
	
}
