package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Test;

public class AssertTests {

	@Test
	public void getLocationTest() throws FileNotFoundException {
		MenuOptions VM500 = new MenuOptions();
		
		
		Map<String, InventoryItem> foodOptions = VM500.getMapOfItems();//new LinkedHashMap<String, InventoryItem>();
//		Chips chip1 = new Chips();
//		chip1.setLocation("A1");
//		foodOptions.put("A1",chip1);
		assertEquals("A1", foodOptions.get("A1").getLocation());
		assertEquals("A2", foodOptions.get("A2").getLocation());
		
		assertEquals("Potato Crisps", foodOptions.get("A1").getItem().trim());
	}
	

}


