package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exception.DatabaseConnectionException;

public class DBUtility {
	private static Connection conn;
	
	public static Connection getDBConn() throws DatabaseConnectionException {
	 String usernameDb="root";
	 String passwordDb="";
	 String urlDb="jdbc:mysql://localhost:3306/carconnect_db";
	 String driverName="com.mysql.jdbc.Driver"; 

		/* Step 2: Load The driver */
		try {
			Class.forName(driverName);
			//System.out.println("Driver loaded successfully..");
		} catch (ClassNotFoundException e) {
			throw new DatabaseConnectionException("Unable to load the Database Driver :(");
		} 
		
		/* Step 3: Establish the connection */
		try {
			conn = DriverManager.getConnection(urlDb, usernameDb, passwordDb);
			//System.out.println("Connection established..");
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Unable to establish a connection to the database :(");
		}
		
		return conn; 
	}
	
	public static void dbClose() {
		try {
			conn.close();
			//System.out.println("Connection closed..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

