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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.model.UserDao;
import org.webproject.workshop3.Workshop3WS.service.UserService;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService userService = new UserService();
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") int userId,  @Context UriInfo uriInfo) throws SQLException {
		if (userId > 0 ) {
			User user = userService.getUserByID(userId);
			user.addLink(getUriForSelf(uriInfo, user), "self");
			return user;
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(@Context UriInfo uriInfo) throws SQLException {
		List<User> loadedUsers = userService.getAllUsers();
		for (User user : loadedUsers) {
			user.addLink(getUriForSelf(uriInfo, user), "self");
		}
		return loadedUsers;
	}
	private String getUriForSelf(UriInfo uriInfo, User user) {
		String uri = uriInfo.getBaseUriBuilder()
		.path(UserResource.class)
		.path(Long.toString(user.getId()))
		.build()
		.toString();
		return uri;
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