package br.com.lucio.escola.shared.dominio;

/* A classe CPF utiliza o contexto Compartilhado, ou seja, ela ficou no pacote shared, e compartilhado entre os pacotes/modulos
 * Também poderiamos duplicar a classe CPF, e deixar ela em ambos os módulos, ficando mais desacoplado, e nehum módulo depende do outro
 * Não existe um certo e um errado*/
public class CPF {

	private String numero;

	public CPF(String numero) {
		if (CpfCnpjValidator.isNotValid(numero)) {
			throw new IllegalArgumentException("CPF invalido");

		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return numero;
	}
	
	
}