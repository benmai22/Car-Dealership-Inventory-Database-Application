package com.ben.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String model;
	private String color;
	private String vin;
	private String manufacturedate;
	
	public Vehicle() {
		this(0, "", "", "", "", "");
	}
	
	public Vehicle(long id, String name, String model, String color, String vin, String manufacturedate) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.color = color;
		this.vin = vin;
		this.manufacturedate = manufacturedate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getManufacturedate() {
		return manufacturedate;
	}

	public void setManufacturedate(String manufacturedate) {
		this.manufacturedate = manufacturedate;
	}
	
	
}
