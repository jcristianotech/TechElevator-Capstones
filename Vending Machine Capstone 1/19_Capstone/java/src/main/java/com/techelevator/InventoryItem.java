package com.techelevator;

public interface InventoryItem {
	
	public String getLocation();
	public void setLocation(String location);
	public String getItem();
	public void setItem(String item);
	public double getPrice(); 	
	public void setPrice(double price); 
	public int getQuantity(); 
	public String consume(); //for the noises at the end
	public void purchase(); //when we want to change quantity
	public String purchaseAndMessage(String getItem);	
	

}
