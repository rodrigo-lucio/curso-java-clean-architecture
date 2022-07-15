package br.com.lucio.escola.aluno;

import static java.util.Objects.isNull;

public class CpfCnpjValidator {

	private static final int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] PESO_CNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	public static boolean isValid(String cpfCnpj) {
		if(isNull(cpfCnpj) ) {
			return false;
		}
		
		if (cpfCnpj.length() == 11) {
			return isValidCPF(cpfCnpj);
		}
		return isValidCNPJ(cpfCnpj);
	}

	public static boolean isNotValid(String cpfCnpj) {
		return !isValid(cpfCnpj);
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if (cpf.isEmpty() || (cpf.length() != 11)){
			return false;
		}
		Integer digito1 = calcularDigito(cpf.substring(0, 9), PESO_CPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, PESO_CPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	public static boolean isValidCNPJ(String cnpj) {
		if (cnpj.isEmpty() || (cnpj.length() != 14)) {
			return false;
		}
		Integer digito1 = calcularDigito(cnpj.substring(0, 12), PESO_CNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, PESO_CNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

}
