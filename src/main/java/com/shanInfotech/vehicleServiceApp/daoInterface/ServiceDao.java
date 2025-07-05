package com.shanInfotech.vehicleServiceApp.daoInterface;

import java.util.List;

import com.shanInfotech.vehicleServiceApp.entity.Service_Records;

public interface ServiceDao {
	public void addService() throws Exception;
	public List<Service_Records> getService() throws Exception;
}
