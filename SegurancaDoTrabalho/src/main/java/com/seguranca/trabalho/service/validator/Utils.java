package com.seguranca.trabalho.service.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Utils {

	public static Boolean validString(String campo) {

		if (campo.trim().length() > 0 && campo != null) {
			return true;

		} else {
			return false;
		}

		// lembre-se de que a comparação
		// com nulo sempre deve vir antes,
		// para evitar chamar métodos em instâncias nulas
	}

	public static boolean validarTelefone(String tel) {

		if ((tel == null) || (tel.length() != 11) || tel.contains("^[a-Z]")) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean validarNumero(String numero) {

		if (numero == null || numero.contains("^[a-Z]")) {
			return false;
		} else {
			return true;
		}
	}

	// ver validação do whit market

	public static boolean validarData(String text) {

		if (text.equalsIgnoreCase("dd/mm/aaaa") || text.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean DifData(String Datainicial, String Datafinal) throws ParseException {

		//2017-11-02 01:59:30.274 formato datetime
		//ver como converter.
		//Date data = new Date(parseDate(Datainicial));
		
		DateFormat formataDataInicial = new SimpleDateFormat("dd/MM/yyyy");
		Date inicialDate = formataDataInicial.parse(Datainicial);

		DateFormat formataDataFinal = new SimpleDateFormat("dd/MM/yyyy");
		Date finalDate = formataDataFinal.parse(Datafinal);

		if (finalDate.before(inicialDate)) return false;

		if (finalDate.equals(inicialDate)) return false;
		
		return true;
	}

	
	
//	public static boolean CnpjUnique(String cnpj) {
//
//		
//	}

	// CPF
	private static final int[] weightSsn = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	// CNPJ
	private static final int[] weightTin = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	private static int calculate(final String str, final int[] weight) {
		int sum = 0;
		for (int i = str.length() - 1, digit; i >= 0; i--) {
			digit = Integer.parseInt(str.substring(i, i + 1));
			sum += digit * weight[weight.length - str.length() + i];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

	/**
	 * Valida CPF
	 *
	 * @param ssn
	 * @return
	 */

	public static boolean isValidCPF(final String ssn) {
		if ((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}"))
			return false;

		final Integer digit1 = calculate(ssn.substring(0, 9), weightSsn);
		final Integer digit2 = calculate(ssn.substring(0, 9) + digit1, weightSsn);
		return ssn.equals(ssn.substring(0, 9) + digit1.toString() + digit2.toString());
	}

	/**
	 * Valida CNPJ
	 *
	 * @param tin
	 * @return
	 */
	public static boolean validCnpj(final String tin) {
		if ((tin == null) || (tin.length() != 14) || tin.matches(tin.charAt(0) + "{14}"))
			return false;

		final Integer digit1 = calculate(tin.substring(0, 12), weightTin);
		final Integer digit2 = calculate(tin.substring(0, 12) + digit1, weightTin);
		return tin.equals(tin.substring(0, 12) + digit1.toString() + digit2.toString());
	}

}
