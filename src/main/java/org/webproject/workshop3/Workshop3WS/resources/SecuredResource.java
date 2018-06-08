package org.webproject.workshop3.Workshop3WS.resources;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webproject.workshop3.Workshop3WS.model.SecuredAuthorized;
import org.webproject.workshop3.Workshop3WS.service.UserService;

@Path("secured")
public class SecuredResource {
	
	UserService userService = new UserService();

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public SecuredAuthorized logIn() throws SQLException {
		SecuredAuthorized securedAuthorized = new SecuredAuthorized();
		securedAuthorized.setAuthorized(true);
		//User user = userService.getUserByID(1);
		return securedAuthorized;
	}

}
