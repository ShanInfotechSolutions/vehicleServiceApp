package com.shanInfotech.vehicleServiceApp.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	static Connection con=null;
	public static Connection connect() throws SQLException {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcEx","root","Root@007");
		return con;
		}
}
