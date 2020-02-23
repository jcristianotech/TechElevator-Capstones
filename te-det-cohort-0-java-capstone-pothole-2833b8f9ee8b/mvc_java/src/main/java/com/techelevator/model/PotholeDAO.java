package com.techelevator.model;

import java.util.List;

public interface PotholeDAO {
	
	public void savePothole(String dateReported, String userId, String latitude, String longitude);
	
	public void addPhoto(String photoURL);
	
	public void deletePothole(String potholeId);
	
	public Object getPotholeById(String potholeId);
	
	public Object getPotholeByDate(String dateReported);
	
	public Object getPotholeByLocation(String location);

	public List<Pothole> showAllPotholes();
	
	public void updateInspection(String potholeId, String dateInspection, String rank, String description);
	
	public void updateRepair(String potholeId, String dateRepaired);
	
	
}
