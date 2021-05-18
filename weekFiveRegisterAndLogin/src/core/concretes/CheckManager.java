package core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.abstracts.CheckService;

public class CheckManager implements CheckService{

	public static final String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; 
	// regex kullan�ld�
	
	
	@Override
	public boolean checkFirstName(String firstName) {
		if (firstName.length()<3) {
			System.out.println("Ad�n�z iki harften fazla olmal�.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(String lastName) {
		if (lastName.length()<3) {
			System.out.println("Soyad�n�z iki harften fazla olmal�.");
			return false;
		}
		return true;
		
	}

	@Override
	public boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			System.err.println("Ge�erli bir mail giriniz.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		if (password.length()<6) {
			System.out.println("�ifreniz 6 harften fazla olmal�. ");
			return false;
		}
		return true;
		
	}

}
