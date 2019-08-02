package com.techelevator;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class MenuOptions {

	public Map<String, InventoryItem> getMapOfItems() throws FileNotFoundException {

		File vendingMachine = new File("vendingmachine.csv");

		Map<String, InventoryItem> foodOptions = new LinkedHashMap<String, InventoryItem>(); // how we get the names,price, slot number for our food options

		String options = "";

		try (Scanner fileScanner = new Scanner(vendingMachine)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] temp = line.split("\\|");

				switch (temp[0].charAt(0)) {
				case 'A':
					Chips chips = new Chips();
					chips.setItem(temp[1]);
					chips.setLocation(temp[0]);
					chips.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], chips);
					break;

				case 'B':
					Candy candy = new Candy();
					candy.setItem(temp[1]);
					candy.setLocation(temp[0]);
					candy.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], candy);
					break;

				case 'C':
					Drink drink = new Drink();
					drink.setItem(temp[1]);
					drink.setLocation(temp[0]);
					drink.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], drink);
					break;

				case 'D':
					Gum gum = new Gum();
					gum.setItem(temp[1]);
					gum.setLocation(temp[0]);
					gum.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], gum);
					break;
					
					

				default:
					System.out.println("Invalid source file!");
				}
			}
		}
		return foodOptions;

	}

}
