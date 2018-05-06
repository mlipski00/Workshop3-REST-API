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

public class GroupDao {

	public static void saveToDB(Group group) throws SQLException {
		Connection conn = DbUtil.getConn();
		PreparedStatement prepStat;
		if(group.getId() ==0) {
			String sql = "INSERT INTO user_group (name) VALUES (?);";
			String columnNames[] = { "ID" };
			prepStat = conn.prepareStatement(sql, columnNames);
			prepStat.setString(1, group.getName());
			prepStat.executeUpdate();
			ResultSet rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				group.setId(rs.getInt(1));
			}
			rs.close();
		}
		else {
			String sql = "UPDATE user_group SET name = ? WHERE ID = ?;";
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, group.getName());
			prepStat.setInt(2, group.getId());
			prepStat.executeUpdate();
			}
		prepStat.close();
		conn.close();
	}

	public static Group loadGroupById(int id) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM user_group WHERE ID = ?;";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, id);
		ResultSet rs = prepStat.executeQuery();
		if (rs.next()) {
			Group group = new Group();
			group.setId(rs.getInt(1));
			group.setName(rs.getString(2));
			return group;
		}
		rs.close();
		prepStat.close();
		conn.close();
		return null;

	}
	
	public static Map<Integer, Group> loadAllGroups () throws SQLException {
		Connection conn = DbUtil.getConn();
		Map<Integer, Group> groups = new HashMap<>();
		String sql = "SELECT * FROM user_group";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			Group group = new Group();
			group.setId(rs.getInt(1));
			group.setName(rs.getString(2));
			groups.put(group.getId(), group);			
		}
		rs.close();
		prepStat.close();
		conn.close();
		return groups;
		
	}
	public static void delete(Group group) throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "DELETE FROM user_group WHERE id = ?;";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setInt(1, group.getId());
		prepStat.executeUpdate();
		group.setId(0);
		prepStat.close();
		conn.close();
	}
	}
