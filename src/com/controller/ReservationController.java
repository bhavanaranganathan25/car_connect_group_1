package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;
import com.model.Admin;
import com.model.Reservation;
import com.service.*;

public class ReservationController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReservationService reservationService=new ReservationService();
		while (true) {
			System.out.println();
			System.out.println("**********RESERVATION OPERATION**********");
			System.out.println("press 1. Get Reservation By Id");
			System.out.println("press 2. Get Reservation By Username");
			System.out.println("press 3. Create Reservation");
			System.out.println("press 4. Update Reservation");
			System.out.println("press 5. Cancel Reservation");
			System.out.println("press 0. for exit");
			System.out.println("**************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				try {
					List<Reservation> list = reservationService.fetchAllReservation();
					System.out.println("Enter  Reservation Id:");
					int id = sc.nextInt();
					Reservation r=reservationService.getReservationById(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Reservation Id",
							"Vehicle Id", "Start Date", "End Date", "Total Cost", "Status"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", r.getReservationId(),r.getCustomerId(),r.getVehicleId(),r.getStartDate(),r.getEndDate(),r.getTotalCost(),r.getStatus().toString()));
				} catch (DatabaseConnectionException | SQLException | InvalidInputException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 2:
				try {
					List<Admin> list = adminService.fetchAllAdmins();
					System.out.println("Enter UserName:");
					String name = sc.next();
					Admin a = adminService.getAdminByUsername(list, name);
					System.out.println();
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Admin Id",
							"First Name", "Last Name", "Phone Number", "User Name", "Password","Role",
							"JoinDate"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", a.getId(),
							a.getFirstName(), a.getLastName(), a.getPhoneNumber(), a.getUserName(),
							a.getPassword(), a.getJoinDate().toString()));
				} catch (SQLException | DatabaseConnectionException | InvalidInputException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 3:
				System.out.println("Enter First Name:");
				String firstName=sc.next();
				System.out.println("Enter Last Name:");
				String lastName=sc.next();
				System.out.println("Enter Email Id:");
				String email=sc.next();
				System.out.println("Enter Phone Number:");
				String phoneNumber=sc.next();
				System.out.println("Enter Username:");
				String username=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				System.out.println("Enter Role:");
				String role=sc.next();
				System.out.println("Enter Join Date:");
				String joinDate=sc.next();
				try {
					adminService.createAdmin(firstName,lastName,email,phoneNumber,username,password,role,joinDate);
					System.out.println("Registration Successfull!!");
				} catch (DatabaseConnectionException |SQLException e) {
					System.out.println(e.getMessage());
				} 
				break;
        case 4:
        	System.out.println("Update the Customer Information");
        	
        	try {
				List<Admin>list = adminService.fetchAllAdmins();
				System.out.println("Enter Admin Id to be updated:");
				int id = sc.nextInt();
				System.out.println();
				Admin a= adminService.getAdminById(list, id);
				System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Admin Id",
						"First Name", "Last Name", "Phone Number", "User Name", "Password","Role",
						"JoinDate"));
				System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", a.getId(),
						a.getFirstName(), a.getLastName(), a.getPhoneNumber(), a.getUserName(),
						a.getPassword(), a.getJoinDate().toString()));
			
				System.out.println("What do you want to update?");
				sc.nextLine();				
				String field=sc.nextLine();
				System.out.println("Enter the new value:");
				String newVal=sc.next();
				adminService.updateAdmin(id,field,newVal);
				System.out.println("Record updated Successfully");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		case 5:
			System.out.println("Enter Customer Id to be deleted");
			int id = sc.nextInt();
			try {
				adminService.deleteAdminById(id);
				System.out.println("Records Deleted!!");
			} catch (SQLException | DatabaseConnectionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
}

	}
}
