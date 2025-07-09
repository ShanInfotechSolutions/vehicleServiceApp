package com.shanInfotech.vehicleServiceApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;
public class AppTest {
	
	@Test
	void testPreventDuplicateRegisterNumber() {
	    VehicleDaoImpl dao = new VehicleDaoImpl();
	    Vehicle v1 = new Vehicle(0, "Shan", "BMW", "KA02LJ0860");

	    try {
	        dao.addVehicle(v1); // first insert
	        dao.addVehicle(v1); // second insert should fail
	        fail("Expected SQLException due to duplicate register number");
	    } catch (SQLException e) {
	        assertTrue(e.getMessage().contains("Duplicate"));
	    }
	}


    @Test
    void testGetVehicleReturnsList() throws Exception {
       
        VehicleDaoImpl dao = new VehicleDaoImpl();
        List<Vehicle> vehicles = dao.getVehicle();
        assertNotNull(vehicles, "getVehicle should return a list (empty if no data)");
        
    }
}
