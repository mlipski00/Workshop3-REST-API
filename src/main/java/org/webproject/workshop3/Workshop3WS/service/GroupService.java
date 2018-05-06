package org.webproject.workshop3.Workshop3WS.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.model.GroupDao;
import org.webproject.workshop3.Workshop3WS.model.User;

public class GroupService {

	private static Map<Integer, Group> groups;

	public GroupService() {
		try {
			groups = GroupDao.loadAllGroups();
		} catch (Exception e) {
			String s = e.getMessage().toString();
		}
	}
	
	public List<Group> getAllGroups() {
		return new ArrayList<Group>(groups.values());
	}

	public Group addGroup(Group group) throws SQLException {
		if (group.getId()!= 0) {
			return null;
		}
		GroupDao.saveToDB(group);
		return group;
	}

	public Group updateGroup(int groupId, Group group) throws SQLException {
		if (groupId==0) {
			return null;
		}
		group.setId(groupId);
		GroupDao.saveToDB(group);
		return group;
	}

	public void removeGroup(int groupId) throws SQLException {
		GroupDao.delete(GroupDao.loadGroupById(groupId));
		
	}
}
