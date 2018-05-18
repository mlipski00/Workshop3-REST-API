package org.webproject.workshop3.Workshop3WS.model;

import java.util.ArrayList;
import java.util.List;

public class Excercise {

	public void setId(int id) {
		this.id = id;
	}

	public Excercise(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Excercise [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	private int id;
	private String title;
	private String description;
	private List<Link> links = new ArrayList<>();

	public Excercise(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Excercise() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
