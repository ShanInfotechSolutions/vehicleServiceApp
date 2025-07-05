package com.shanInfotech.vehicleServiceApp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.shanInfotech.vehicleServiceApp.daoInterface.ServiceDao;
import com.shanInfotech.vehicleServiceApp.dbConnection.DbConnect;
import com.shanInfotech.vehicleServiceApp.entity.Service_Records;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class ServiceDaoImpl implements ServiceDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	VehicleDaoImpl vdao=new VehicleDaoImpl();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addService() throws SQLException {
        List<Vehicle> vehicles = vdao.getVehicle();
        System.out.println("Available Vehicles:");
        vehicles.forEach(System.out::println);

        System.out.print("Enter Vehicle ID for the service: ");
        int userVid = sc.nextInt();
        sc.nextLine();

        Optional<Vehicle> matchedVehicle = vehicles.stream()//Optional -- checks for null, doesn't throw nullpointerexception
            .filter(v -> v.getVid() == userVid)
            .findFirst();

        if (matchedVehicle.isEmpty()) {
            System.out.println("Vehicle ID not found. Cannot insert service record.");
            return;
        }

        System.out.print("Enter Service Record ID: ");
        int rid = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Service Date (YYYY-MM-DD): ");
        String sDate = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Cost: ");
        double cost = sc.nextDouble();

        Service_Records sr = new Service_Records(rid, sDate, desc, cost, matchedVehicle.get());

        con = DbConnect.connect();
        con.setAutoCommit(false);

        String insertService = "INSERT INTO service_records VALUES (?, ?, ?, ?, ?)";
        ps = con.prepareStatement(insertService);

        ps.setInt(1, sr.getRid());
        ps.setString(2, sr.getsDate());
        ps.setString(3, sr.getDescript());
        ps.setDouble(4, sr.getCost());
        ps.setInt(5, sr.getVehicleId().getVid());

        ps.executeUpdate();
        con.commit();
        System.out.println("Service Record Data Inserted");

        con.close();
		}

	@Override
	public List<Service_Records> getService() throws Exception {
		List<Service_Records> list = new ArrayList<>();
	    List<Vehicle> vehicles = vdao.getVehicle(); 
	    con = DbConnect.connect();
	    ps = con.prepareStatement("SELECT * FROM service_records");
	    rs = ps.executeQuery();
	    while (rs.next()) {
	        int vehicleIdFromService = rs.getInt(1);
	        Vehicle matchedVehicle = vehicles.stream()
	            .filter(v -> v.getVid() == vehicleIdFromService)
	            .findFirst()
	            .orElse(null);

	        Service_Records r = new Service_Records(
	            rs.getInt(1),
	            rs.getString(2),
	            rs.getString(3),
	            rs.getDouble(4),
	            matchedVehicle
	        );
	        list.add(r);
	    }
	    con.close();
	    return list;
	}

	
}