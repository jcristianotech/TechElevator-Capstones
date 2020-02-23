package com.techelevator.model;

public class Pothole {
	private String potholeId;
	private String dateReported;
	private String photoURL;
	private String userId;
	private String latitude;
	private String longitude;
	private String staffId;
	private String dateInspected;
	private String dateRepaired;
	private String rank;
	private String description;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPotholeId() {
		return potholeId;
	}
	public void setPotholeId(String potholeId) {
		this.potholeId = potholeId;
	}
	public String getDateReported() {
		return dateReported;
	}
	public void setDateReported(String dateReported) {
		this.dateReported = dateReported;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getDateInspected() {
		return dateInspected;
	}
	public void setDateInspected(String dateInspected) {
		this.dateInspected = dateInspected;
	}
	public String getDateRepaired() {
		return dateRepaired;
	}
	public void setDateRepaired(String dateRepaired) {
		this.dateRepaired = dateRepaired;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
