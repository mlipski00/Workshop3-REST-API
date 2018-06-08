package org.webproject.workshop3.Workshop3WS.model;

import java.util.ArrayList;
import java.util.List;

import org.webproject.workshop3.Workshop3WS.utils.BCrypt;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private int person_group_id;
	private List<Link> links = new ArrayList<>();

	public int getId() {
		return id;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(int id, String username, String email, String password, int person_group_id) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.setPassword(password);
		this.person_group_id = person_group_id;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());

	}

	public void setPaswordWithoutHashing(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPerson_group_id() {
		return person_group_id;
	}

	public void setPerson_group_id(int person_group_id) {
		this.person_group_id = person_group_id;
	}

	public User(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.setPassword(password);
	}
	
	public User(int id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.setPassword(password);
	}

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", person_group_id=" + person_group_id + "]\n";
	}


}
