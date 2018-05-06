package org.webproject.workshop3.Workshop3WS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.webproject.workshop3.Workshop3WS.model.Group;
import org.webproject.workshop3.Workshop3WS.model.GroupDao;

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
}
