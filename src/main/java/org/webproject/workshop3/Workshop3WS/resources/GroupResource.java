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

import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.service.GroupService;

@Path("/group")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {

	GroupService groupService = new GroupService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Group> getGroup(@QueryParam("groupId") int groupId) throws SQLException {
		if (groupId > 0 ) {
			List<Group> loadedGroup = new ArrayList<>();
			loadedGroup.add(groupService.getGroupByID(groupId));
			return loadedGroup;
		}
		return groupService.getAllGroups();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Group addUser(Group group) throws SQLException {
		return groupService.addGroup(group);
	}
	
	@PUT
	@Path("/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Group updateGroup(@PathParam("groupId") int groupId, Group group) throws SQLException {
		return groupService.updateGroup(groupId, group);
		 
	}
	
	@DELETE
	@Path("/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteGroup(@PathParam("groupId") int groupId) throws SQLException {
		groupService.removeGroup(groupId);
	}
	
}
