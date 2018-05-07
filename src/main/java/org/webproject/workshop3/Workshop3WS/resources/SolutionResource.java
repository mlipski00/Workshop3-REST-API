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
	public List<Solution> getSolution(@QueryParam("solutionId") int solutionId) throws SQLException {
		if (solutionId > 0 ) {
			List<Solution> loadedSolution = new ArrayList<>();
			loadedSolution.add(solutionService.getSolutionByID(solutionId));
			return loadedSolution;
		}
		return solutionService.getAllUsers();
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
	
	
}
