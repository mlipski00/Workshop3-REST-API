package org.webproject.workshop3.Workshop3WS.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.Excercise;
import org.webproject.workshop3.Workshop3WS.model.ExcerciseDao;

public class ExcerciseService {

	private static Map<Integer, Excercise> excercises;

	public ExcerciseService() {
		try {
			excercises = ExcerciseDao.loadAllExcercises();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Excercise> getAllExcercises() {
		return new ArrayList<Excercise>(excercises.values());
	}

	public Excercise addExcercise(Excercise excercise) throws SQLException {
		ExcerciseDao.saveToDB(excercise);
		return excercise;
	}

	public Excercise getExcerciseByID(int excerciseId) throws SQLException {
		return ExcerciseDao.loadExcerciseById(excerciseId);

	}

	public void removeExcercise(int excerciseId) throws SQLException {

		ExcerciseDao.delete(ExcerciseDao.loadExcerciseById(excerciseId));

	}

	public Excercise updateExcercise(int excerciseId, Excercise excercise) throws SQLException {
		if (excerciseId==0) {
			return null;
		}
		excercise.setId(excerciseId);
		ExcerciseDao.saveToDB(excercise);
		return excercise;
	}

}
