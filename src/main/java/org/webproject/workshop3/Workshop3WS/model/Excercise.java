package org.webproject.workshop3.Workshop3WS.model;

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

	@Override
	public String toString() {
		return "Excercise [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	private int id;
	private String title;
	private String description;

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

}
