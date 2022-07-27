package br.com.lucio.escola.academico.infra.aluno;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.lucio.escola.academico.dominio.aluno.HashSenha;

public class HashSenhaMD5Impl implements HashSenha {

	@Override
	public String criarHashSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("erro ao gerar hash da senha");
		}
	}

	@Override
	public boolean isSenhaValida(String senhaHash, String senhaDigitada) {
		return senhaHash.equals(criarHashSenha(senhaDigitada));
	}

}
