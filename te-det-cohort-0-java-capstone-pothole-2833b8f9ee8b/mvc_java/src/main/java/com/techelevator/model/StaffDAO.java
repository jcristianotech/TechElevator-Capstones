package com.techelevator.model;

public interface StaffDAO {
	
	public boolean saveStaff(String staffId, String firstName, String lastName, String password, String email);

	public void updatePassword(String staffId, String email, String password);

	public Object getStaffByStaffId(String staffId);
	
	public Object getStaffByEmail(String email);

	public boolean searchForEmailAndPassword(String staffId, String password);
}
