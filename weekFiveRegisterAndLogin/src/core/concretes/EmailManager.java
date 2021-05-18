package core.concretes;

import core.abstracts.EmailService;
import entities.concretes.User;

public class EmailManager implements EmailService {
	
	@Override
	public void sendVerifyEmail(User user) {
		System.out.println("Doðrulama linki e-mail adresinize gönderildi: " + user.getEmail());
		
	}

	@Override
	public void clickToVerify(User user) {
		System.out.println("Hesabýnýzý onaylamak için týklayýn: " + user.getName());
		
	}

}
