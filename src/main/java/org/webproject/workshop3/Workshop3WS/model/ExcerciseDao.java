package org.webproject.workshop3.Workshop3WS.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.utils.DbUtil;


public class ExcerciseDao {

	public static void saveToDB(Excercise excercise) throws SQLException {
		Connection conn = DbUtil.getConn();
		PreparedStatement prepStat;
		ResultSet rs = null;
		if (excercise.getId() == 0) {
			String sql = "INSERT INTO excercise (title, description) VALUES (?, ?);";
			String autoGeneratedKeys[] = { "ID" };
			prepStat = conn.prepareStatement(sql, autoGeneratedKeys);
			prepStat.setString(1, excercise.getTitle());
			prepStat.setString(2, excercise.getDescription());
			prepStat.executeUpdate();
			rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				excercise.setId(rs.getInt(1));
			}
			rs.close();
		} else {
			String sql = "UPDATE excercise SET title=?, description=? WHERE ID = ?;";
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, excercise.getTitle());
			prepStat.setString(2, excercise.getDescription());
			prepStat.setInt(3, excercise.getId());
			prepStat.executeUpdate();
		}
		prepStat.close();
		conn.close();
	}

	public static Excercise loadExcerciseById(int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM excercise WHERE id=?;";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();
		if (rs.next()) {
			Excercise excercise = new Excercise();
			excercise.setId(rs.getInt(1));
			excercise.setTitle(rs.getString(2));
			excercise.setDescription(rs.getString(3));
			return excercise;
		}
		rs.close();
		prepStat.close();
		conn.close();
		return null;
	}

	 public static Map<Integer, Excercise> loadAllExcercises () throws SQLException {
		Connection conn = DbUtil.getConn();
		Map<Integer, Excercise> excercises = new HashMap<Integer, Excercise>();
		String sql = "SELECT * FROM excercise;";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Excercise excercise = new Excercise();
			excercise.setId(rs.getInt(1));
			excercise.setTitle(rs.getString(2));
			excercise.setDescription(rs.getString(3));
			excercises.put(excercise.getId(), excercise);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return excercises;
	}
	
	public static void delete(Excercise excercise) throws SQLException {
		Connection conn = DbUtil.getConn();
		if (excercise.getId() != 0) {
			String sql = "DELETE FROM excercise WHERE id = ?;";
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, excercise.getId());
			prepStat.executeUpdate();
			excercise.setId(0);
			prepStat.close();
			conn.close();
		}
	}
	
}
