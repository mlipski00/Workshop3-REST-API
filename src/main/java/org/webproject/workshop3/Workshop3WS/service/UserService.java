package org.webproject.workshop3.Workshop3WS.service;

import java.awt.Transparency;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.model.UserDao;

public class UserService {
	
	private static Map<Integer, User> users;
	
	public UserService() {
		try {
			users = UserDao.loadAllUsers();
		} catch (Exception e) {
		}
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}
	
	public User getUserByID(int userId) throws SQLException {
		return UserDao.loadUserById(userId);
	}

	public User addUser(User user) throws SQLException {
		if (user.getId()!= 0) {
			return null;
		}
		UserDao.saveToDB(user);
		return user;
	}

	public User updateUser(int userId, User user) throws SQLException {
		if (userId== 0) {
			return null;
		}
		user.setId(userId);
		UserDao.saveToDB(user);
		return user;
	}
	public User removeUser(int userId) throws SQLException {
		User user = UserDao.loadUserById(userId);
		UserDao.delete(user);
		return user;
	}

}
