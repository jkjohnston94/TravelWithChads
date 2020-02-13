package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {

		while (true) {

			Chad menuOption = View.inputHandler(View.displayMenu());
			if (menuOption == Chad.QUIT) {
				View.displayExit();
			}
			if (menuOption == Chad.ERROR) {
				View.displayError();
			} else {
				Handler(menuOption);
			}

		}

	}

	public static void Handler(Chad menuOption) {

		if (menuOption == Chad.DISPLAYALL) {

			View.displayOutput(new DatabaseHandler().output());
			
		} else if (menuOption == Chad.ZIPCODE) {

			int zip = Integer.parseInt(View.getZip());
			
			
			while(true) {
				Chad subMenuOption = View.inputHandler(View.displaySubMenu(zip));
				
				if (subMenuOption == Chad.OUTPUTALL) {
					Vehicle[] vehiclesOut = filterByZip(new DatabaseHandler().output(), zip);
					View.displayOutput(vehiclesOut);
				}
				if (subMenuOption == Chad.AVAILABLEVEHICLES) {
					int noVehicles = getAvailableVehicles(zip);
					View.displayOutput(noVehicles);
				}
				if (subMenuOption == Chad.OUTPUTDAILYRATE) {
					Double dailyRate = getDailyRate(zip);
					View.displayOutput(dailyRate, subMenuOption);
				}
				if (subMenuOption == Chad.DAILYREVENUE) {
					Double dailyRevenue = getDailyRevenue(zip);
					View.displayOutput(dailyRevenue, subMenuOption);
				}
				if (subMenuOption == Chad.ADDVEHICLE) {
					addVehicle();
				}
				if (subMenuOption == Chad.REMOVEVEHICLE) {
					removeVehicle();
				}
				if (subMenuOption == Chad.ERROR) {
					View.displayError();
				}
				if (subMenuOption == Chad.RETURNTOMAIN) {
					break;
				}
				if (subMenuOption == Chad.QUIT) {
					View.displayExit();
				}
			}
			
			
		} else if (menuOption == Chad.NAME) {

			String locationName = View.getName();
			while(true) {
				Chad subMenuOption = View.inputHandler(View.displaySubMenu(locationName));

				if (subMenuOption == Chad.OUTPUTALL) {
					Vehicle[] vehiclesOut = new DatabaseHandler().output();
					View.displayOutput(vehiclesOut);
				}
				if (subMenuOption == Chad.AVAILABLEVEHICLES) {
					int noVehicles = getAvailableVehicles(locationName);
					View.displayOutput(noVehicles);
				}
				if (subMenuOption == Chad.OUTPUTDAILYRATE) {
					double dailyRate = getDailyRate(locationName);
					View.displayOutput(dailyRate, subMenuOption);
				}
				if (subMenuOption == Chad.DAILYREVENUE) {
					Double dailyRevenue = getDailyRevenue(locationName);
					View.displayOutput(dailyRevenue, subMenuOption);
				}
				if (subMenuOption == Chad.ADDVEHICLE) {
					addVehicle();
				}
				if (subMenuOption == Chad.REMOVEVEHICLE) {
					removeVehicle();
				}
				if (subMenuOption == Chad.ERROR) {
					View.displayError();
				}
				if (subMenuOption == Chad.RETURNTOMAIN) {
					break;
				}
				if (subMenuOption == Chad.QUIT) {
					View.displayExit();
				}
			}
		}	

	}

	static Vehicle[] filterByZip(Vehicle[] v, int zipCode) {
		int size = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getZipCode() == zipCode) {
				size++;
			}
		}
		Vehicle[] output = new Vehicle[size];
		int count = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getZipCode() == zipCode) {
				output[count] = v[i];
				count++;
			}
		}
		return output;
	}

	static Vehicle[] filterByName(Vehicle[] v, String locationName) {
		int size = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getLocationName().equalsIgnoreCase(locationName)) {
				size++;
			}
		}
		Vehicle[] output = new Vehicle[size];
		int count = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getLocationName().equalsIgnoreCase(locationName)) {
				output[count] = v[i];
				count++;
			}
		}
		return output;
	}

	static int getAvailableVehicles(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		int count = 0;
		for (Vehicle v : output) {
			count += (v.getVehicleCount() - v.getVehicleRentCount());
		}
		return count;
	}

	static int getAvailableVehicles(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		int count = 0;
		for (Vehicle v : output) {
			count += (v.getVehicleCount() - v.getVehicleRentCount());
		}
		return count;
	}

	static double getDailyRate(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		double rate = 0;
		for (Vehicle v : output) {
			rate += v.getRentalRate();
		}
		rate = (rate / output.length);
		return rate;
	}

	static double getDailyRate(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		double rate = 0;
		for (Vehicle v : output) {
			rate += v.getRentalRate();
		}
		rate = (rate / output.length);
		return rate;
	}

	static double getDailyRevenue(int zipCode) {
		Vehicle[] output = filterByZip(new DatabaseHandler().output(), zipCode);
		double dailyRevenue = 0;
		for (Vehicle v : output) {
			dailyRevenue = (v.getRentalRate() * v.getVehicleRentCount());
		}
		return dailyRevenue;
	}

	static double getDailyRevenue(String locationName) {
		Vehicle[] output = filterByName(new DatabaseHandler().output(), locationName);
		double dailyRevenue = 0;
		for (Vehicle v : output) {
			dailyRevenue = (v.getRentalRate() * v.getVehicleRentCount());
		}
		return dailyRevenue;
	}

	static void addVehicle() {
		double rentalRate;
		String locationName;
		int zipCode;
		String make;
		String model;
		int totalVehicles;
		int totalVehiclesRented;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean numberChecked = false;
		while (!numberChecked) {
			try {

				System.out.println("Please enter the rental rate: ");
				rentalRate = Double.parseDouble(br.readLine());
				System.out.println("Please enter the location name: ");
				locationName = br.readLine();
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(br.readLine());
				System.out.println("Please enter the vehicle make: ");
				make = br.readLine();
				System.out.println("Please enter the vehicle model: ");
				model = br.readLine();
				System.out.println("Please enter the total vehicles: ");
				totalVehicles = Integer.parseInt(br.readLine());
				System.out.println("Please enter the total vehicles rented: ");
				totalVehiclesRented = Integer.parseInt(br.readLine());

				Vehicle v = new Vehicle(rentalRate, locationName, zipCode, make, model, totalVehicles,
						totalVehiclesRented);
				new DatabaseHandler().input(v);
				numberChecked = true;

			} catch (NumberFormatException | IOException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
				e.printStackTrace();
			}
		}
	}
	
	static void removeVehicle() {
		String locationName;
		int zipCode;
		String make;
		String model;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean numberChecked = false;
		while (!numberChecked) {
			try {
				
				System.out.println("Please enter the location name: ");
				locationName = br.readLine();
				System.out.println("Please enter the zip code: ");
				zipCode = Integer.parseInt(br.readLine());
				System.out.println("Please enter the vehicle make: ");
				make = br.readLine();
				System.out.println("Please enter the vehicle model: ");
				model = br.readLine();
				
				Vehicle v = new Vehicle(0.0, locationName, zipCode, make, model, 0,
						0);
				new DatabaseHandler().removeVehicle(v);
				numberChecked = true;

			} catch (NumberFormatException | IOException e) {
				System.out.println("BRO, THAT IS NOT COOL!");
				e.printStackTrace();
			}
		}
	}

}
