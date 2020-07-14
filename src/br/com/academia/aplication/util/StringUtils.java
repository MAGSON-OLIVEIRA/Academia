package br.com.academia.aplication.util;

import java.util.List;

public class StringUtils {

	public static boolean isEmpty(String s) {
		if(s==null) {
			return true;
		}
		return s.trim().length() == 0;
	}
	
	public static String lefZeroes(int value, int finalSize) {
		return String.format("%0"+finalSize+"d", value);
	}
	
	public static String joinStringUtils(List<String> textList, String separador) {
		String out = "";
		if (textList.size() == 0) {
			return out;
		}
		StringBuilder sb = new StringBuilder();
		textList.forEach(s -> {
			if (!isEmpty(s)) {
				sb.append(s + separador);
			}
		});
		String s = sb.toString();
		if (s.length() >= 0) {
			if (isEmpty(separador)) {
				out = s;
			} else {
				out = s.substring(0, s.length() - 1);
			}
		}
		return out;
	}

}
