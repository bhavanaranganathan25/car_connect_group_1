package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Admin;
import com.model.Customer;
import com.util.DBUtility;

public class AdminDaoImpl implements AdminDao {

	@Override
	public List<Admin> fetchAllAdmins() throws SQLException, DatabaseConnectionException {
		List<Admin> list = new ArrayList<>();
		Connection conn = DBUtility.getDBConn();

		String sql = "select * from customer";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			String email = rst.getString("email");
			String phoneNumber = rst.getString("phone_number");
			String username = rst.getString("username");
			String password = rst.getString("password");
			String role= rst.getString("role");
			LocalDate joinDate = rst.getDate("join_date").toLocalDate();
			Admin a= new Admin(id, firstName, lastName, email, phoneNumber, username, password,role,
					joinDate);
			list.add(a);
		}

		DBUtility.dbClose();
		return (list);
		
	}

	@Override
	public void createCustomer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String role, String joinDate) throws SQLException, DatabaseConnectionException {
		Connection conn = DBUtility.getDBConn();

		String sql = "insert into admin(first_name,last_name,email,phone_number,username,password,role,join_date) values(?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, email);
		pstmt.setString(4, phoneNumber);
		pstmt.setString(5, username);
		pstmt.setString(6, password);
		pstmt.setString(7, role);
		java.sql.Date JoinDate = java.sql.Date.valueOf(joinDate);
		pstmt.setDate(8, JoinDate);

		pstmt.executeUpdate();

		DBUtility.dbClose();

		
	}

	@Override
	public void updateAdmin(int id, String fieldd, String newVal) throws SQLException, DatabaseConnectionException {
		Connection conn = DBUtility.getDBConn();

		String sql = "update admin set "+fieldd+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(fieldd.equals("registration_date")) {
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

	@Override
	public void deleteAdminById(int id) throws SQLException, DatabaseConnectionException {
Connection conn = DBUtility.getDBConn();
		
		String sql = "delete from admin where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		DBUtility.dbClose();
		
	}

}
