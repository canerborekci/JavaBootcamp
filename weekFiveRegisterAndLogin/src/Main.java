import business.abstracts.UserService;
import business.concretes.LoginManager;
import business.concretes.UserManager;
import core.adapters.GoogleManagerAdapter;
import core.concretes.CheckManager;
import core.concretes.EmailManager;
import dataAccess.concretes.CanerUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService=new UserManager(new LoginManager(new EmailManager(), new CheckManager(), new CanerUserDao()), 
				new GoogleManagerAdapter()); 
		
		User user = new User(1, "Caner", "Börekçi","canerbaba@gmail.com","1234567");
		userService.register(user);
		userService.login("canerbaba@gmail.com", "1234567");

		
		System.out.println("--Google--");
		userService.registerToGoogle();
		
		User user1 = new User(2, "ülkü", "karaca", "ulkukaraca@gmail.com","23571");
		userService.register(user1);
		userService.login("ulkukaraca@gmail.com", "7321");

		

}
}