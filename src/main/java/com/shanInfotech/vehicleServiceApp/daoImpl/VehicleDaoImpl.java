package com.shanInfotech.vehicleServiceApp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shanInfotech.vehicleServiceApp.daoInterface.VehicleDao;
import com.shanInfotech.vehicleServiceApp.dbConnection.DbConnect;
import com.shanInfotech.vehicleServiceApp.entity.Vehicle;

public class VehicleDaoImpl implements VehicleDao{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addVehicle(Vehicle v) throws SQLException {

		    con = DbConnect.connect();
		    con.setAutoCommit(false);

		    String insertVehicle = "INSERT INTO vehicles VALUES (?, ?, ?, ?)";
		    ps = con.prepareStatement(insertVehicle);
		    ps.setInt(1, v.getVid());
		    ps.setString(2, v.getOwner());
		    ps.setString(3, v.getModel());
		    ps.setString(4, v.getRegisterNumber());

		    ps.executeUpdate();
		    con.commit();
		    System.out.println("Vehicle Data Inserted");

		    con.close();
}

	public List<Vehicle> getVehicle() throws SQLException {
	    List<Vehicle> list = new ArrayList<>();
	    Connection con = DbConnect.connect();
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicles");
	    rs = ps.executeQuery();
	    while (rs.next()) {
	        list.add(new Vehicle(
	            rs.getInt(1),
	            rs.getString(2),
	            rs.getString(3),
	            rs.getString(4)
	        ));
	    }
	    return list;
	}

}
