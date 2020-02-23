package com.techelevator.model;

public interface UserDAO {

	public boolean saveUser(String firstName, String lastName, String email, String password);

	public void updatePassword(String userId, String email, String password);

	public Object getUserByUserId(String userId);
	
	public Object getUserByEmail(String email);

	boolean searchForEmailAndPassword(String email, String password);

}
