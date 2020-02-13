package alpha;

public class Vehicle {

	private double rentalRate;
	private String locationName;
	private int zipCode;
	private String make;
	private String model;
	private int totalVehicles;
	private int totalVehiclesRented;
	
	public Vehicle() {
		
	}
	
	public Vehicle(double rentRate, String locName, int zip, String mk, String mdl, int totalveh, int totalvr) {
		this.rentalRate = rentRate;
		this.locationName = locName;
		this.zipCode = zip;
		this.make = mk;
		this.model = mdl;
		this.totalVehicles = totalveh;
		this.totalVehiclesRented = totalvr;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	public String getLocationName() {
		return locationName;
	}
	public int getVehicleCount() {
		return totalVehicles;
	}
	public int getVehicleRentCount(){
		return totalVehiclesRented;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		String output = String.format(
				"%s,%s,%s,%s,%s,%s,%s"
				, rentalRate, locationName, zipCode, make, model, totalVehicles, totalVehiclesRented);
		return output;
	}
	
}
