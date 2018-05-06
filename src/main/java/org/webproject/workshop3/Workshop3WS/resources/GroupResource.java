package org.webproject.workshop3.Workshop3WS.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.model.GroupDao;
import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.model.UserDao;
import org.webproject.workshop3.Workshop3WS.service.GroupService;

@Path("/group")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {

	GroupService groupService = new GroupService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Group> getGroup() throws SQLException {
		return groupService.getAllGroups();
	}
	
}
