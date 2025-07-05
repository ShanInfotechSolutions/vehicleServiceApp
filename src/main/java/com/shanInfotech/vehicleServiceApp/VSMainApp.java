package com.shanInfotech.vehicleServiceApp;

import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.daoInterface.VehicleDao;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class VSMainApp {
	public static void main(String[] args) throws Exception {
	    Vehicle v = new Vehicle(103, "Shanmukh", "Swift", "KA01AB9999");
	    VehicleDao dao = new VehicleDaoImpl();
	   // dao.addVehicle();
	    //System.out.println("Inserted: " + v);
	    dao.getVehicle();
	}


}
