package com.shanInfotech.vehicleServiceApp;

import java.util.List;

import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.daoInterface.VehicleDao;
//import com.shanInfotech.vehicleServiceApp.entity.Vehicle;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class VSMainApp {
	public static void main(String[] args) throws Exception {
		VehicleDao dao = new VehicleDaoImpl();
        List<Vehicle> vehicles = dao.getVehicle();

        System.out.println("List of Vehicles:");
        for (Vehicle v : vehicles) {
            System.out.println(v); // This uses the toString() of Vehicle class
        }
	}
}
