package core.abstracts;

import entities.concretes.User;

public interface EmailService {
	void sendVerifyEmail(User user);
	void clickToVerify(User user);
}
