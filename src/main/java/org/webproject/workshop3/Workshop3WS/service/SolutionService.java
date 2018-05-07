package org.webproject.workshop3.Workshop3WS.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.model.GroupDao;
import org.webproject.workshop3.Workshop3WS.model.Solution;
import org.webproject.workshop3.Workshop3WS.model.SolutionDao;

public class SolutionService {

	Map<Integer, Solution> solutions;

	public SolutionService() {
		try {
			solutions = SolutionDao.loadAllSolutions();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Solution> getAllUsers() {
		return new ArrayList<Solution>(solutions.values());
	}

	public Solution addSolution(Solution solution) throws SQLException {
		if (solution.getId() != 0) {
			return null;
		}
		SolutionDao.saveToDB(solution);
		return solution;
	}
	public Solution getSolutionByID(int SolutionId) throws SQLException {
		return SolutionDao.loadSolutionById(SolutionId);
	}

	public Solution updateSolution(int solutionId, Solution solution) throws SQLException {
		if (solutionId == 0) {
			return null;
		}
		solution.setId(solutionId);
		SolutionDao.saveToDB(solution);
		return solution;
	}

	public void removeSolution(int solutionId) throws SQLException {
		SolutionDao.delete(SolutionDao.loadSolutionById(solutionId));

	}

}
