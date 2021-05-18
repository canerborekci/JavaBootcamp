package core.concretes;

import core.abstracts.EmailService;
import entities.concretes.User;

public class EmailManager implements EmailService {
	
	@Override
	public void sendVerifyEmail(User user) {
		System.out.println("Do�rulama linki e-mail adresinize g�nderildi: " + user.getEmail());
		
	}

	@Override
	public void clickToVerify(User user) {
		System.out.println("Hesab�n�z� onaylamak i�in t�klay�n: " + user.getName());
		
	}

}
