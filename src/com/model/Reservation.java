package com.model;

import java.time.LocalDate;

public class Reservation {
	private int reservationId;
	private int customerId;
	private int vehicleId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int totalCost;
	private String status;
	public Reservation() {
		}
	public Reservation(int reservationId, int customerId, int vehicleId, LocalDate startDate, LocalDate endDate,
			int totalCost, String status) {
		super();
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.status = status;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", customerId=" + customerId + ", vehicleId=" + vehicleId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalCost=" + totalCost + ", status="
				+ status + "]";
	}
	
}
