package com.shanInfotech.vehicleServiceApp.daoInterface;

import java.util.List;

import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public interface VehicleDao {
	public void addVehicle(Vehicle v) throws Exception;
	public List<Vehicle> getVehicle() throws Exception;
}
