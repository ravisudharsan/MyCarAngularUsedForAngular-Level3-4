package com.car.demo.model;

public class Car {

	private int id;
	private String name;
	private String model;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Car(int id, String name, String model) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
	}
	
	
}
