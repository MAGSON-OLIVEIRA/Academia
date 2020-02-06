package br.com.academia.aplication.util;

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

}
