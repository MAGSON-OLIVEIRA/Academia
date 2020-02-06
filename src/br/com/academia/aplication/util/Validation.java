package br.com.academia.aplication.util;

public class Validation {
	
	public static void assertNotEmpty(Object obj) throws ValidationException {
		if(obj instanceof String) {
			String s = (String) obj;
			
			if(StringUtils.isEmpty(s)) {
				throw new ValidationException("O texto n�o pode ser null");
			}
		}
		
		if(obj==null) {
			throw new ValidationException("N�o pode ser null");
		}
		
	}

}
