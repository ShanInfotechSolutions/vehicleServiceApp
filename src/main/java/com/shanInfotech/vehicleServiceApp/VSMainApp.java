package com.shanInfotech.vehicleServiceApp;

import java.util.List;
import java.util.Scanner;

import com.shanInfotech.vehicleServiceApp.daoImpl.VehicleDaoImpl;
import com.shanInfotech.vehicleServiceApp.daoInterface.VehicleDao;
//import com.shanInfotech.vehicleServiceApp.entity.Vehicle;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class VSMainApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        VehicleDao dao = new VehicleDaoImpl();

        try {
            System.out.print("Enter Vehicle ID: ");
            int vid = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Owner Name: ");
            String owner = sc.nextLine();
            System.out.print("Enter Vehicle Model: ");
            String model = sc.nextLine();
            System.out.print("Enter Registration Number: ");
            String regNo = sc.nextLine();

            Vehicle v = new Vehicle(vid, owner, model, regNo);
            dao.addVehicle(v);
            System.out.println("Vehicle added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
}
}