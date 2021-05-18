package business.concretes;

import business.abstracts.LoginService;
import core.abstracts.CheckService;
import core.abstracts.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class LoginManager implements LoginService{
	private EmailService emailService;
	private CheckService checkService;
	private UserDao userDao;
	
	public LoginManager(EmailService emailService, CheckService checkService, UserDao userDao) {
		super();
		this.emailService = emailService;
		this.checkService = checkService;
		this.userDao = userDao;
	}

	public void register(User user) {
		
		if (!userDao.checkEmailExists(user)) {
			System.out.println("Bu e-mail zatem var. " + user.getEmail());
			return;
		}
		if (checkService.checkFirstName(user.getName())) {
			System.out.println("Ýsim onaylandý");
		}
		else {
			return;
		}
		if (checkService.checkLastName(user.getLastname())) {
			System.out.println("Soyad onaylandý");
		}
		else {
			return;
		}
		if (checkService.checkEmail(user.getEmail())) {
			System.out.println("E-mail onaylandý.");
		}
		else {
			return;
		}
		if (checkService.checkPassword(user.getPassword())) {
			System.out.println("Þifre Onaylandý.");
		}
		else {
			return;
		}
		
		emailService.sendVerifyEmail(user);
		emailService.clickToVerify(user);
		userDao.add(user);
		System.out.println("Kayýt Baþarýlý, hoþgeldiniz  " + user.getName() + " !");
		
	}
	
	public void login(String email, String password) {
		for (User users : userDao.getAll()) {
			if (email==users.getEmail()) {
				
				if(password!=users.getPassword()) {
					System.out.println("Giriþ Baþarýsýz");
					return;
				}
				System.out.println("Giriþ Baþarýlý");
				return;
				
			}

		}
		
	}
}
