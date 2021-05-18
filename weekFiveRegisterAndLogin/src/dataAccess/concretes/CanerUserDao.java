package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class CanerUserDao implements UserDao {
public List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullanýcý eklendi : " + user.getName());
		
	}

	@Override
	public void delete(User user) {
		this.users.remove(user);
		System.out.println("Kullanýcý silindi: " + user.getName());
		
	}

	@Override
	public List<User> getAll() {
		
		return this.users;
	}

	@Override
	public boolean checkEmailExists(User user) {
			for (User person : users) {
				if (person.getEmail()==user.getEmail()) {
					return false;
				}
			}	
			return true;
	}

}
