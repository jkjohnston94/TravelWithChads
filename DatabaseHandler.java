package alpha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseHandler {

	final File fileCar = new File("carDatabase.txt");
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private BufferedWriter bw;

	
	public void input(Vehicle v) {
		
		try {
			
			if(!fileCar.exists()) {
				fileCar.createNewFile();
			}
			
			fw = new FileWriter(fileCar, true);
			bw = new BufferedWriter(fw);
			bw.write(v.toString()+ "\n");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Vehicle[] output() {
		int length = getLength();
		int count = 0;
		Vehicle [] output = new Vehicle[length];
		
		try {
			if(!fileCar.exists()) {
				output = null;
			}
			
			fr = new FileReader(fileCar);
			br = new BufferedReader(fr);
			String line = "";
			
			while((line = br.readLine())!=null) {
				String [] temp = line.split(",");
				output[count] = new Vehicle(
						Double.parseDouble(temp[0]), 
						temp[1], 
						Integer.parseInt(temp[2]), 
						temp[3], 
						temp[4],
						Integer.parseInt(temp[5]),
						Integer.parseInt(temp[6])
								);
				count++;
			}
			
			br.close();
			fr.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return output;
		
	}
	
	public void removeVehicle(Vehicle v) {
		
		try {
			fr = new FileReader(fileCar);
			br = new BufferedReader(fr);
			
			String line = "";
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine())!=null) {
				String []temp = line.split(",");
				if(
					v.getLocationName().equalsIgnoreCase(temp[1]) &&
					v.getZipCode()==Integer.parseInt(temp[2]) &&
					v.getMake().equalsIgnoreCase(temp[3]) &&
					v.getModel().equalsIgnoreCase(temp[4])
					) {
					//element will not be included in the StringBuilder
				} else {
					for(int i=0; i<7; i++) {
						
						if(i==6) {
							sb.append(temp[i]);
						} else {
							sb.append(temp[i]).append(",");
						}
					}
					sb.append("\n");
				}
			}
			fw = new FileWriter(fileCar);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			fw.close();
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getLength() {
		int length = 0;
		try {
			fr = new FileReader(fileCar);
			br = new BufferedReader(fr);
			String line = "";
			
			while((line=br.readLine())!=null) {
				length++;
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return length;
	}

}
