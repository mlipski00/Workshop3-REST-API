package org.webproject.workshop3.Workshop3WS.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.utils.BCrypt;

public class SecuredService {

	public static boolean verify(String username, String password) {
		UserService userService = new UserService();
		List<User> loadedUsers = userService.getAllUsers();
		Map<String, String> userCredentials = new HashMap<>();
		for (User user : loadedUsers) {
			userCredentials.put(user.getEmail(), user.getPassword());
		}

		if (userCredentials.get(username) != null && BCrypt.checkpw(password, userCredentials.get(username))) {
			return true;
		}
		return false;
	}
}
