package org.webproject.workshop3.Workshop3WS.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.model.UserDao;
import org.webproject.workshop3.Workshop3WS.service.UserService;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser(@QueryParam("userId") int userId) throws SQLException {
		if (userId > 0 ) {
			List<User> loadedUser = new ArrayList<>();
			loadedUser.add(userService.getUserByID(userId));
			return loadedUser;
		}
		return userService.getAllUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) throws SQLException {
		return userService.addUser(user);
	}
	
	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("userId") int userId, User user ) throws SQLException {
		return userService.updateUser(userId, user);
		 
	}
	
	@DELETE
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("userId") int userId) throws SQLException {
		userService.removeUser(userId);
	}
	
}
