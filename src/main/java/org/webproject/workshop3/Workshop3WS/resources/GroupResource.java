package org.webproject.workshop3.Workshop3WS.resources;

import java.sql.SQLException;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.service.GroupService;

@Path("/group")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {

	GroupService groupService = new GroupService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Group> getGroups(@Context UriInfo uriInfo) throws SQLException {
		List<Group> loadedGroups = groupService.getAllGroups();
		for (Group group : loadedGroups) {
			group.addLink(getUriForSelf(uriInfo, group), "self");
		}
		return loadedGroups;
	}

	@GET
	@Path("/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Group getGroup(@PathParam("groupId") int groupId, @Context UriInfo uriInfo) throws SQLException {
		if (groupId > 0) {
			Group group = groupService.getGroupByID(groupId);
			group.addLink(getUriForSelf(uriInfo, group), "self");
			return group;
		}
		return null;
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

//	@OPTIONS
//	@Path("{path : .*}")
//	public Response options() {
//		return Response.ok("").header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Credentials", "true")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//				.header("Access-Control-Max-Age", "1209600").build();
//	}

	private String getUriForSelf(UriInfo uriInfo, Group group) {
		String uri = uriInfo.getBaseUriBuilder().path(GroupResource.class).path(Long.toString(group.getId())).build()
				.toString();
		return uri;
	}
}
