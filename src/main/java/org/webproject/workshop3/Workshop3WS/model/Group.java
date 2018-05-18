package org.webproject.workshop3.Workshop3WS.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	private int id;
	private String name;
	private List<Link> links = new ArrayList<>();

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
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
