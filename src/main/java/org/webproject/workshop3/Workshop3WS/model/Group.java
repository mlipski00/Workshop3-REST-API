package org.webproject.workshop3.Workshop3WS.model;

public class Group {

	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Group(String name) {
		this.name = name;
	}

	public Group() {

	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
