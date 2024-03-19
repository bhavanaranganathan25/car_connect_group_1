package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Admin;

public interface AdminDao {

	List<Admin> fetchAllAdmins() throws SQLException, DatabaseConnectionException;

	void createCustomer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String role, String joinDate) throws SQLException, DatabaseConnectionException;

	void updateAdmin(int id, String fieldd, String newVal) throws SQLException, DatabaseConnectionException;

	void deleteAdminById(int id) throws SQLException, DatabaseConnectionException;

}
