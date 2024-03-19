package com.dao;

import java.sql.SQLException;
import java.util.*;
import com.model.*;
import com.exception.*;
public interface CustomerDao {

	List<Customer> fetchAllCustomers() throws SQLException, DatabaseConnectionException;

	void createCustomer(String firstName, String lastName, String email,String phoneNumber, String address, String username,
			String password, String registrationDate) throws DatabaseConnectionException, SQLException;

	void updateCustomer(int id, String field, String newVal) throws DatabaseConnectionException, SQLException;

	void deleteCustomerById(int id) throws SQLException, DatabaseConnectionException;

}
