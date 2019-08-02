package com.techelevator;

public class Gum implements InventoryItem {

	private String item = ""; 
	private String location = ""; 
	private double price = 0.00;
	private int quantity = 5;

	@Override
	public String getItem() {
		if (item.length() <= 18) {
			return item + "                ";
		} else {
		return item;
		}
	}
	
	@Override
	public void setItem(String item) {
		this.item = item; 
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		this.location = location; 
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price; 
	}

	@Override
	public int getQuantity() {
		return quantity;
	}


	@Override
	public String consume() {
		return "Chew Chew, Yum!";
	}

	@Override
	public void purchase() {
		if (this.quantity > 0) {
			this.quantity -= 1; 
		}
	}
	
	public String purchaseAndMessage(String getName) {
		
		String message ="";
		if (this.quantity == 0) {
			message += "This item is SOLD OUT";
		} else {
			message += "You selected " + getName;
			this.quantity -= 1; 
		}
		return message;
	}
}
