package org.webproject.workshop3.Workshop3WS.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.webproject.workshop3.Workshop3WS.model.Excercise;
import org.webproject.workshop3.Workshop3WS.service.ExcerciseService;

@Path("/excercise")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExcerciseResource {

	ExcerciseService excerciseService = new ExcerciseService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excercise> getExcercises(@Context UriInfo uriInfo) throws SQLException {
			List<Excercise> loadedExcercises = excerciseService.getAllExcercises();
			for (Excercise excercise : loadedExcercises) {
				excercise.addLink(getUriForSelf(uriInfo, excercise), "self");
			}
		return loadedExcercises;
	}
	
	@GET
	@Path("/{excerciseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excercise getExcercise(@PathParam("excerciseId") int excerciseId, @Context UriInfo uriInfo) throws SQLException {
		if (excerciseId > 0 ) {
			Excercise excercise = excerciseService.getExcerciseByID(excerciseId);
			excercise.addLink(getUriForSelf(uriInfo, excercise), "self");
			return excercise;
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Excercise addExcercise(Excercise excercise) throws SQLException {
		return excerciseService.addExcercise(excercise);
	}
	
	@PUT
	@Path("/{excerciseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Excercise updateUser(@PathParam("excerciseId") int excerciseId, Excercise excercise ) throws SQLException {
		return excerciseService.updateExcercise(excerciseId, excercise);
		 
	}
	
	@DELETE
	@Path("/{excerciseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteExcercise(@PathParam("excerciseId") int excerciseId) throws SQLException {
		excerciseService.removeExcercise(excerciseId);
	}
	
	private String getUriForSelf(UriInfo uriInfo, Excercise excercise) {
		String uri = uriInfo.getBaseUriBuilder()
		.path(ExcerciseResource.class)
		.path(Long.toString(excercise.getId()))
		.build()
		.toString();
		return uri;
	}
}
