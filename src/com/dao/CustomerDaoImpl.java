package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import com.model.*;
import com.util.DBUtility;
import com.exception.*;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> fetchAllCustomers() throws SQLException, DatabaseConnectionException {
		List<Customer> list = new ArrayList<>();
		Connection conn = DBUtility.getDBConn();

		String sql = "select * from customer";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			;
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			;
			String email = rst.getString("email");
			;
			String phoneNumber = rst.getString("phone_number");
			;
			String address = rst.getString("address");
			String username = rst.getString("username");
			String password = rst.getString("password");
			LocalDate registrationDate = rst.getDate("registration_date").toLocalDate();
			Customer c = new Customer(id, firstName, lastName, email, phoneNumber, address, username, password,
					registrationDate);
			list.add(c);
		}

		DBUtility.dbClose();
		return (list);
	}

	@Override
	public void createCustomer(String firstName, String lastName, String email, String phoneNumber, String address,
			String username, String password, String registrationDate) throws DatabaseConnectionException, SQLException {
		Connection conn = DBUtility.getDBConn();

		String sql = "insert into customer(first_name,last_name,email,phone_number,address,username,password,registration_date) values(?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, email);
		pstmt.setString(4, phoneNumber);
		pstmt.setString(5, address);
		pstmt.setString(6, username);
		pstmt.setString(7, password);
		java.sql.Date RegistrationDate = java.sql.Date.valueOf(registrationDate);
		pstmt.setDate(8, RegistrationDate);

		pstmt.executeUpdate();

		DBUtility.dbClose();

	}


	public void updateCustomer(int id, String field, String newVal) throws DatabaseConnectionException, SQLException {
		
		Connection conn = DBUtility.getDBConn();

		String sql = "update customer set "+field+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(field.equals("registration_date")) {
			LocalDate local=LocalDate.parse(newVal);
			java.sql.Date sqlDate = java.sql.Date.valueOf(local);
             pstmt.setDate(1, sqlDate);
		}
		
		else 
			pstmt.setString(1,newVal);
		
		pstmt.setInt(2, id);


		pstmt.executeUpdate();

		DBUtility.dbClose();
	}


	public void deleteCustomerById(int id) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtility.getDBConn();
		
		String sql = "delete from reservation where customer_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		sql = "delete from customer where id=?";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		DBUtility.dbClose();
		
	}

}
