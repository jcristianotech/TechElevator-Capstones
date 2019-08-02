package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.DispenseChange;

public class VendingMachineCLI extends MenuOptions{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_TRANSACTION = "Complete Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT,
			SUB_MENU_OPTION_TRANSACTION };

	private static final String FEED_OPTION_1 = "add $1";
	private static final String FEED_OPTION_2 = "add $2";
	private static final String FEED_OPTION_3 = "add $5";
	private static final String FEED_OPTION_4 = "add $10";
	private static final String[] FEED_MENU_OPTIONS = { FEED_OPTION_1, FEED_OPTION_2, FEED_OPTION_3, FEED_OPTION_4 };

	private static final String SALESREPORT = "SalesReport.txt";
	private static final String SALESLOG = "SalesLog.txt";

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	
	
	private Menu menu;
	static Scanner in = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
	Date date = new Date();
	double totDollarSold = 0;
	int totQtySold = 0;

	public void run() throws IOException {

		// objects we need access to throughout
		Map<String, InventoryItem> foodOptions = new LinkedHashMap<String, InventoryItem>(); // creating empty map to
																								// fill with items
		MenuOptions VM500 = new MenuOptions();
		for (String s : VM500.getMapOfItems().keySet()) { // populating our local Map with items from the MenuOptions
															// class
			foodOptions.put(s, VM500.getMapOfItems().get(s));
		}
		DispenseChange dispenseChange = new DispenseChange();

		CustomerBalance customerBalance = new CustomerBalance();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items, start here and make this work first
				// System.out.println("Slot " + "Item " + "Price " + "Quantity");

				for (String y : foodOptions.keySet()) {

					System.out.print(foodOptions.get(y).getLocation() + " ");
					System.out.print(foodOptions.get(y).getItem().substring(0, 18) + " ");
					System.out.print("$" + String.format("%.2f", foodOptions.get(y).getPrice()) + " ");

					if (foodOptions.get(y).getQuantity() != 0) {
						System.out.print(foodOptions.get(y).getQuantity());
					} else {
						System.out.print("SOLD OUT");
					}

					System.out.println("");
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) { // audit is in the format date, time, what happened,
																	// amount of money, amount of money again
				List<String> sounds = new ArrayList<String>();
				List<String> audit = new ArrayList<String>();
				List<String> report = new ArrayList<String>();

				while (true) {
					System.out.println("Currrent Money Provided: " + "$"
							+ String.format("%.2f", customerBalance.getCurrentMoney())); // add customer money total
																							// here

					String choice2 = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

					if (choice2.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						String choice3 = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
						double add = 0;
						if (choice3.equals(FEED_OPTION_1)) {
							customerBalance.addToCurrent(1.0);
							add = 1.00;
						} else if (choice3.equals(FEED_OPTION_2)) {
							customerBalance.addToCurrent(2.0);
							add = 2.00;
						} else if (choice3.equals(FEED_OPTION_3)) {
							customerBalance.addToCurrent(5.0);
							add = 5.00;
						} else { // option 4
							customerBalance.addToCurrent(10.0);
							add = 10.00;
						}
						audit.add(dateFormat.format(date) + " FEED MONEY:  " + "$" + String.format("%.2f", add) + "      " + "$" + String.format("%.2f", customerBalance.getCurrentMoney()));
//						report.add(arg0)

					} else if (choice2.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {

						String userChoice = in.nextLine();
						System.out.println("Please enter the product slot to purchase");
						double priorBalance = 0;

						if (foodOptions.get(userChoice) == null || foodOptions.get(userChoice).getPrice() > customerBalance.getCurrentMoney()) {
							System.out.println("Invalid choice.");
							System.out.println("");
						} else {

							System.out.println(foodOptions.get(userChoice).purchaseAndMessage(foodOptions.get(userChoice).getItem()));
							if (foodOptions.get(userChoice).getQuantity() >= 0) {
								customerBalance.subractFromCurrent(foodOptions.get(userChoice).getPrice());
								sounds.add(foodOptions.get(userChoice).consume());
								priorBalance = (customerBalance.getCurrentMoney()
										+ foodOptions.get(userChoice).getPrice());
								audit.add(dateFormat.format(date) + " " + foodOptions.get(userChoice).getItem().substring(0, 9) + " " + foodOptions.get(userChoice).getLocation() + " $" + String.format("%.2f", priorBalance) + "      " + "$" + String.format("%.2f", customerBalance.getCurrentMoney()));
								totDollarSold += foodOptions.get(userChoice).getPrice();
								totQtySold = (foodOptions.get(userChoice).getQuantity());
								report.add(foodOptions.get(userChoice).getItem() + "   " + totQtySold);
							}
						}

					} else if (choice2.equals(SUB_MENU_OPTION_TRANSACTION)) {


						audit.add(dateFormat.format(date) + " " + "GIVE CHANGE: " + "$"
								+ String.format("%.2f", customerBalance.getCurrentMoney()) + "      " + "$"
								+ String.format("%.2f", 0.0));
//						report.add(foodOptions.get(userChoice).getItem() + "   " + currentQuantity);
						System.out.printf("Your change is: $%.2f\n", customerBalance.getCurrentMoney());
						customerBalance.subractFromCurrent(customerBalance.getCurrentMoney());

						for (String sound : sounds) {
							System.out.println(sound);
						}


//						File inventoryReport = new File("C:\\Users\\John Cristiano\\workspace\\java-capstone-module-1-team-2\\19_Capstone\\java\\SalesReport.txt");
//						PrintWriter writer3 = new PrintWriter(inventoryReport);
//				
//						writer3.write(foodOptions.get(choice2).getItem() + " | " + totQtySold); // changed "println" to "write"
																										// for each
//				
//						
						File log = new File(SALESLOG);
						try (FileWriter writer = new FileWriter(log.getAbsoluteFile(), true)) {
							for (String x : audit) {
								writer.write(x + "\n");
							}
							writer.flush();
						}
						// break;

						File salesReport = new File(SALESREPORT);
						for (String z: report)	System.out.println(z); // Margaret check code to see if line reached
						try (FileWriter writer2 = new FileWriter(salesReport.getAbsoluteFile(), true)) {
							for (String z : report) {
								writer2.write(z + "\n");
							}
							writer2.write("TOTAL SALES** $" + (totDollarSold) + "\n");
							writer2.flush();
							writer2.close();
						}
//				writer3.println("TOTAL SALES** $" + (totDollarSold));
//				writer3.close();
						break;
					}
				}
			}
		}
	}
}
