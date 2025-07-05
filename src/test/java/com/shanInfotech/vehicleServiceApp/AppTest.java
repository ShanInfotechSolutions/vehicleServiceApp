package com.shanInfotech.vehicleServiceApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;
public class AppTest {
	// Keep a backup of original System.in to restore after tests
    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn);  // restore standard input
    }

    @Test
    void testAddVehicleWithSimulatedInput() throws Exception {
        // Simulate user input for Vehicle ID, Owner, Model, Registration Number:
        String simulatedInput = "102\nShan\nBMW\nKA02LJ0860\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        // Instantiate DAO and call the method under test
        VehicleDaoImpl dao = new VehicleDaoImpl();
        dao.addVehicle();  // This will read from the simulatedInput instead of console
        
        // Now verify that the vehicle was added (e.g., by retrieving it from the DB)
        List<Vehicle> vehicles = dao.getVehicle();
        // Assuming the database was empty before, now it should contain one entry
        assertFalse(vehicles.isEmpty(), "Vehicle list should not be empty after adding a vehicle");
        
        // Get the most recently added vehicle (or find by ID 101)
        Vehicle added = vehicles.stream()
                                .filter(v -> v.getVid() == 101)
                                .findFirst()
                                .orElse(null);
        assertNotNull(added, "Added vehicle with ID 101 should be present in the list");
        assertEquals("John Doe", added.getOwner());
        assertEquals("Tesla Model 3", added.getModel());
        assertEquals("ABC1234", added.getRegisterNumber());
    }

    @Test
    void testGetVehicleReturnsList() throws Exception {
        // Optionally, you might want to test getVehicle() separately.
        VehicleDaoImpl dao = new VehicleDaoImpl();
        List<Vehicle> vehicles = dao.getVehicle();
        assertNotNull(vehicles, "getVehicle should return a list (empty if no data)");
        // (Further assertions can be made if test DB is pre-populated with known data)
    }
}
