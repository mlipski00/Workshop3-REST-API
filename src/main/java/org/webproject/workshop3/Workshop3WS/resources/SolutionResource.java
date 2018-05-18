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

import org.webproject.workshop3.Workshop3WS.model.Solution;
import org.webproject.workshop3.Workshop3WS.model.SolutionDao;
import org.webproject.workshop3.Workshop3WS.model.User;
import org.webproject.workshop3.Workshop3WS.service.SolutionService;

@Path("/solution")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SolutionResource {

	SolutionService solutionService = new SolutionService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Solution> getSolutions( @Context UriInfo uriInfo) throws SQLException {
		List<Solution> loadedSolutions = solutionService.getAllSolutions();
		for (Solution solution : loadedSolutions) {
			solution.addLink(getUriForSelf(uriInfo, solution), "self");
		}
		return loadedSolutions; 
	}
	
	@GET
	@Path("/{solutionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Solution getSolution(@PathParam("solutionId") int solutionId, @Context UriInfo uriInfo) throws SQLException {
		if (solutionId > 0 ) {
			Solution solution = solutionService.getSolutionByID(solutionId);
			solution.addLink(getUriForSelf(uriInfo, solution), "self");
			return solution;			
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Solution addSolution(Solution solution) throws SQLException {
		return solutionService.addSolution(solution);
	}
	
	@PUT
	@Path("/{solutionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Solution updateSolution(@PathParam("solutionId") int solutionId, Solution solution) throws SQLException {
		return solutionService.updateSolution(solutionId, solution);
		 
	}
	
	@DELETE
	@Path("/{solutionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSolution(@PathParam("solutionId") int solutionId) throws SQLException {
		solutionService.removeSolution(solutionId);
	}
	
	private String getUriForSelf(UriInfo uriInfo, Solution solution) {
		String uri = uriInfo.getBaseUriBuilder()
		.path(SolutionResource.class)
		.path(Long.toString(solution.getId()))
		.build()
		.toString();
		return uri;
	}
	
}
