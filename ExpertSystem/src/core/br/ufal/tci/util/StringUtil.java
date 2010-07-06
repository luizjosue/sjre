package br.ufal.tci.util;

public class StringUtil {
	public static boolean isEmpty(String mensagem) {
		return mensagem == null || mensagem.trim().length() == 0;
	}
}
