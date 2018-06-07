package org.webproject.workshop3.Workshop3WS.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecuredResource {
	
	@GET
	@Path("login")
	@Produces(MediaType.TEXT_PLAIN)
	public String logIn() {
		return "AccessGranted ";
	}

}
