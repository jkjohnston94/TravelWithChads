package alpha;

public enum Chad {

	DISPLAYALL,ZIPCODE,OUTPUTDAILYRATE,AVAILABLEVEHICLES,
	DAILYREVENUE,NAME,ADDVEHICLE,REMOVEVEHICLE,QUIT,ERROR,
	OUTPUTALL, RETURNTOMAIN;
	
	private String Chad() {
		switch(ordinal()) {
		case 0:
			return "Display All";
		case 1:
			return "Zipcode";
		case 2:
			return "OutputDailyRate";
		case 3:
			return "AvailableVehicles";
		case 4:
			return "DailyRevenue";
		case 5:
			return "Name";
		case 6:
			return "AddVehicle";
		case 7:
			return "RemoveVehicle";
		case 8:
			return "Quit";
		case 9:
			return "BRO!!";
		case 10:
			return "OutputAll Bro";
		case 11:
			return "We are headed back to main Bro!";
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		switch(ordinal()) {
		case 0:
			return "Display All";
		case 1:
			return "Zipcode";
		case 2:
			return "OutputDailyRate";
		case 3:
			return "AvailableVehicles";
		case 4:
			return "DailyRevenue";
		case 5:
			return "Name";
		case 6:
			return "AddVehicle";
		case 7:
			return "RemoveVehicle";
		case 8:
			return "Quit";
		case 9:
			return "BRO!!";
		case 10:
			return "OutputAll Bro";
		case 11:
			return "We are headed back to main Bro!";
		default:
			return null;
		}
	}
}
