package com.example.restservice.domain;

public class Entity {

	private String id;
	private String type;
	private String color;
	
	public Entity() {
		
	}
	
	public Entity(String id, String type, String color) {
		this.id = id;
		this.type = type;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
