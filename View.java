package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class View {
	
	
	public static Chad inputHandler(String input) {
		
		switch(input) {
		case "0": return Chad.DISPLAYALL;
		case "1": return Chad.NAME;
		case "2": return Chad.ZIPCODE;
		case "sub.0": return Chad.OUTPUTALL;
		case "sub.1": return Chad.OUTPUTDAILYRATE;
		case "sub.2": return Chad.AVAILABLEVEHICLES;
		case "sub.3": return Chad.ADDVEHICLE;
		case "sub.4": return Chad.REMOVEVEHICLE;
		case "sub.r": return Chad.RETURNTOMAIN;
		default:  
			if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("sub.q")) {
				return Chad.QUIT;
			} else {
				return Chad.ERROR;
			}
			
		}

		
	}
	
	public static String displayMenu() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("-------Welcome to TravelWithChad.com BackOffice-------\n");
		System.out.println("Display all rentals:        Enter 0");
		System.out.println("Search rentals by location: Enter 1");
		System.out.println("Search rentals by zipcode:  Enter 2");
		System.out.println("Quit:                       Enter Q");
		System.out.println();
		
		String input = "";
		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	public static String displaySubMenu(String locationName) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("-------TravelWithChad.com BackOffice-------");
		System.out.println("Showing results for : " + locationName);
		System.out.println();
		System.out.println("Display all rentals:                   Enter 0");
		System.out.println("Display Daily Rates:                   Enter 1");
		System.out.println("Display Number of Available Vehicles:  Enter 2");
		System.out.println("Add Vehicle:                           Enter 3");
		System.out.println("Remove Vehicle:                        Enter 4");
		System.out.println("Return to Main Menu:                   Enter R");
		System.out.println("Quit:                                  Enter Q");
		System.out.println();
		
		String input = "";
		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "sub." + input;
	}
	
	public static String displaySubMenu(int zip) {
		return displaySubMenu( "" + zip );
	}

	public static void displayError() {
		
		System.out.println(Chad.ERROR.toString());
	}
	
	public static String getZip() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a zip code to search");
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static String getName() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a Location Name to search");
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void displayOutput(Vehicle[] vehicles) {
		
		for(Vehicle vehicle : vehicles) {
			System.out.println("------------RENTALS------------\n");
			System.out.println("Make and Model: " + vehicle.getMake() + " " + vehicle.getModel());
			System.out.println("Location: " + vehicle.getLocationName());
			System.out.println("ZipCode: " + vehicle.getZipCode());
			System.out.println("Rental Rate: " + vehicle.getRentalRate());
			System.out.println("Number Available: " + vehicle.getVehicleRentCount());
			System.out.println("Total Vehicles: " + vehicle.getVehicleCount());
			System.out.println("-------------------------------\n");
		}
	}
	
	public static void displayOutput(int noVehicles) {
			
			System.out.println("---NUMBER AVAILABLE RENTALS---\n");
			System.out.println("Number rentals Available: " + noVehicles);
			System.out.println("------------------------------\\n");
	}
	
	public static void displayOutput(Double output, Chad rateOrRevenue) {
		if (rateOrRevenue == Chad.DAILYREVENUE) {
			System.out.println("----------TOTAL REVENUE-------\n");
			System.out.println("Total Revenue: " + output);
			System.out.println("------------------------------\n");
		}
		if (rateOrRevenue == Chad.OUTPUTDAILYRATE) {
			System.out.println("----------RENTAL RATE-------\n");
			System.out.println("Rental Rate: " + output);
			System.out.println("------------------------------\n");
		}
	}
	
	
	public static void displayOutput(String message) {
		
		System.out.println("\n" + message + "\n");
		
	}
	
	public static void displayExit() {
		System.out.println("BRAH... I'M OUT!");
		System.exit(0);
	}
}
