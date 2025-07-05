package com.shanInfotech.vehicleServiceApp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.shanInfotech.vehicleServiceApp.daoImpl.ServiceDaoImpl;
import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.daoInterface.ServiceDao;
import com.shanInfotech.vehicleServiceApp.daoInterface.VehicleDao;
import com.shanInfotech.vehicleServiceApp.entity.Service_Records;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class App {
    public static void main(String[] args) throws SQLException {
    	VehicleDao vdao = new VehicleDaoImpl();
        ServiceDao sdao = new ServiceDaoImpl();

        try {
            vdao.addVehicle();
            sdao.addService();

            List<Vehicle> vehicles = vdao.getVehicle();
            System.out.println("\nAll Vehicles:");
            vehicles.forEach(System.out::println);

            List<Service_Records> services = sdao.getService();
            System.out.println("\n️ All Service Records:");
            services.forEach(System.out::println);

            System.out.println("\n Filtered: Service Cost > ₹1000");
            services.stream()
                .filter(sr -> sr.getCost() > 1000)
                .forEach(System.out::println);

            System.out.println("\nGrouped by Cost Category:");
            Map<String, List<Service_Records>> grouped = services.stream()
                .collect(Collectors.groupingBy(sr -> {
                    if (sr.getCost() < 1000) return "Low";
                    else if (sr.getCost() <= 2000) return "Medium";
                    else return "High";
                }));

            grouped.forEach((category, list) -> {
                System.out.println(category + " Cost:");
                list.forEach(System.out::println);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}