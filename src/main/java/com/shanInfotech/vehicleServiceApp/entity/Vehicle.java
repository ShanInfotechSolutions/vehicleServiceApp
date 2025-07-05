package com.shanInfotech.vehicleServiceApp.entity;

//CREATE TABLE vehicles (
//	    vehicle_id INT PRIMARY KEY,
//	    owner_name VARCHAR(100) NOT NULL,
//	    model VARCHAR(100) NOT NULL,
//	    registration_number VARCHAR(20) UNIQUE NOT NULL
//	);

public class Vehicle {
	private int vid;
	private String owner;
	private String model;
	private String registerNumber;
	
	public Vehicle() {
	}

	public Vehicle(int vid, String owner, String model, String registerNumber) {
		this.vid = vid;
		this.owner = owner;
		this.model = model;
		this.registerNumber = registerNumber;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", owner=" + owner + ", model=" + model + ", registerNumber=" + registerNumber
				+ "]";
	}
}
