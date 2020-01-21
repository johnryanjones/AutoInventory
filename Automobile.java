import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Automobile {
	
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	private String vin;
	
	static ArrayList<Automobile> Autos = new ArrayList<Automobile> ();
	private static Scanner addInput = new Scanner(System.in);
	
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public int getYear() {
		return year;
	}
	public int getMileage() {
		return mileage;
	}
	public String getVin() {
		return vin;
	}
	
	public void setMake(String m) {
		make = m;
	}
	public void setModel(String mo) {
		model = mo;
	}
	public void setColor(String c) {
		color = c;
	}
	public void setYear(int y) {
		year = y;
	}
	public void setMileage(int mi) {
		mileage = mi;
	}
	public void setVin(String v) {
		vin = v;
	}

	public Automobile() {
	}
	
	public Automobile(String ma, String mo, String c, int y, int mi, String v) {
		make = ma;
		model = mo;
		color = c;
		year = y;
		mileage = mi;
		vin = v;
	}
	public static void RemoveVehicle() throws Exception {
		
		System.out.print("Please enter the VIN of the vehicle you would like to remove: ");
		String v = addInput.next();
		
		for (int i = 0; i < Autos.size(); i++) {
			if (Autos.get(i).vin.equalsIgnoreCase(v)) {
				Autos.remove(i);
			}
		}
		System.out.println("Success! Vehicle Removed.");
	}
	public static void UpdateVehicle() {
		System.out.print("Please enter the VIN of the vehicle you would like to update: ");
		String v = addInput.next();
		
		for (int i = 0; i < Autos.size(); i++) {
			if (Autos.get(i).vin.equalsIgnoreCase(v)) {
				System.out.print("Please enter the attribute you would like to update: ");
				String update = addInput.next();
				
				switch (update.toLowerCase()) {
				
				case "make":
					System.out.print("What is the new Make of the vehicle: ");
					Autos.get(i).make = addInput.next();
					System.out.println("Success! Vehicle Updated.");
					break;
				case "model":
					System.out.print("What is the new Model of the vehicle: ");
					Autos.get(i).model = addInput.next();
					System.out.println("Success! Vehicle Updated.");
					break;
				case "color":
					System.out.print("What is the new Color of the vehicle: ");
					Autos.get(i).color = addInput.next();
					System.out.println("Success! Vehicle Updated.");
					break;
				case "year":
					System.out.print("What is the new Year of the vehicle: ");
					Autos.get(i).year = addInput.nextInt();
					System.out.println("Success! Vehicle Updated.");
					break;
				case "mileage":
					System.out.print("What is the new Mileage of the vehicle: ");
					Autos.get(i).mileage = addInput.nextInt();
					System.out.println("Success! Vehicle Updated.");
					break;
				case "vin":
					System.out.print("What is the new VIN of the vehicle: ");
					Autos.get(i).make = addInput.next();
					System.out.println("Success! Vehicle Updated.");
					break;
				default:
					System.out.println("I'm sorry I did not understand you.");
					break;
				}
			}
		}
	}
	public static void addVehicle() {
		
		System.out.println("Begin adding a new vehicle to the inventory list...");
		System.out.print("Please enter the make of the vehicle: ");
		String m = addInput.next();
		
		System.out.print("Please enter the model: ");
		String mo = addInput.next();
		
		System.out.print("Please enter the color: ");
		String c = addInput.next();
		
		System.out.print("Please enter the year of the vehicle: ");
		int y = addInput.nextInt();
		
		System.out.print("Please enter the mileage: ");
		int mi = addInput.nextInt();
		
		System.out.print("Please enter the VIN: ");
		String v = addInput.next();
		
		Automobile.Autos.add(new Automobile(m, mo, c, y, mi, v));
		
		System.out.println("Success! Vehicle added.");
	}
	
	public String toString()
	{
		return "Make: " + make + ", " + "Model: " + model + ", " + "Color: " + color + ", " + "Year: " + year + ", " + "Mileage: " + mileage + ", " + "VIN: " + vin;
	}
	
	public static void displayList() {
		for (int i = 0; i < Automobile.Autos.size(); ++i) {
			System.out.println("" + (i+1) + " - " + Automobile.Autos.get(i));
		}
	}
	public static void displayMoreInfo() {
		for (Automobile a : Automobile.Autos) {
			System.out.println("Make: " + a.make + ", Model: " + a.model + ", Color: " + a.color + ", Year: " + a.year + ", Mileage: " + a.mileage + ", VIN: " + a.vin);
		}
	}
	public static void PrintFile() {
		FileOutputStream file = null;
		PrintWriter outFS = null;
		try {
			file = new FileOutputStream("myoutput.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outFS = new PrintWriter(file);
		System.out.println();
		System.out.print("Are you sure you wish to print to file? \"Yes\" or \"No\": ");
		String answer = addInput.next();
		System.out.println();
		
		switch (answer.toLowerCase()) {
		
		case "yes":
			for (int i = 0; i < Automobile.Autos.size(); ++i) {
				outFS.println("" + (i+1) + " - " + Automobile.Autos.get(i));
			}
				outFS.flush();
			try {
				file.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
			System.out.println("Success!");
			System.out.println();
			break;
		case "no":
			break;
		default:
			System.out.println("I'm sorry I did not understand you.");
			System.out.println();
			break;
		}
	}

}
