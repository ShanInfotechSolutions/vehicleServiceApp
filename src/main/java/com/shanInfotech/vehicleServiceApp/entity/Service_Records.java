package com.shanInfotech.vehicleServiceApp.entity;



public class Service_Records {
	private int rid;
	private String sDate;
	private String descript;
	private double cost;
	private Vehicle vehicleId;
	
	public Service_Records() {
	}
	
	public Service_Records(int rid, String sDate, String descript, double cost, Vehicle vehicleId) {
		this.rid = rid;
		this.sDate = sDate;
		this.descript = descript;
		this.cost = cost;
		this.vehicleId = vehicleId;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Vehicle getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Vehicle vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Service_Records [rid=" + rid + ", sDate=" + sDate + ", descript=" + descript + ", cost=" + cost
				+ ", vehicleId=" + vehicleId + "]";
	}
}
