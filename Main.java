import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Automobile car1 = new Automobile("Ford", "Escort", "Blue", 1996, 56565, "001");
		Automobile car2 = new Automobile("Chevrolet", "Silverado", "White", 2005, 43122, "002");
		Automobile.Autos.add(car1);
		Automobile.Autos.add(car2);
		Automobile.Autos.add(new Automobile("Ford", "F150", "Red", 2001, 54345, "003"));		
		Automobile.displayList();
		System.out.println();
		Scanner in = new Scanner(System.in);
		String userInput;
		
		do {
		System.out.print("Type \"add\" , \"remove\" , \"update\" , \"print\" or \"quit\": ");
		userInput = in.next();
		
			if (userInput.equalsIgnoreCase("remove")) {
				
				try {
				
				System.out.println();	
				Automobile.RemoveVehicle();
				System.out.println();
				System.out.println("Please see the updated vehicle list below...");
				System.out.println();
				Automobile.displayList();
				System.out.println();
				
				} catch (Exception excpt) {
					
					System.out.println();
					System.out.println(excpt.getMessage());
					System.out.println("Failure.");
					System.out.println();
					Automobile.displayList();
					System.out.println();
				}
			}
			if (userInput.equalsIgnoreCase("add")) {
				
				try {
				
				System.out.println();
				Automobile.addVehicle();
				System.out.println();
				System.out.println("Please see the updated vehicle list below...");
				System.out.println();
				Automobile.displayList();
				System.out.println();
				
				} catch (Exception excpt) {
					
					System.out.println();
					System.out.println(excpt.getMessage());
					System.out.println("Failure.");
					System.out.println();
					Automobile.displayList();
					System.out.println();
				}
			}
			if (userInput.equalsIgnoreCase("update")) {
				
				try {
				
				System.out.println();
				Automobile.UpdateVehicle();
				System.out.println();
				System.out.println("Please see the updated vehicle list below...");
				System.out.println();
				Automobile.displayList();
				System.out.println();
				
				} catch (Exception excpt) {
					System.out.println();
					System.out.println(excpt.getMessage());
					System.out.println("Failure.");
					System.out.println();
					Automobile.displayList();
					System.out.println();
				}
			}
			if (userInput.equalsIgnoreCase("print")) {
				
				try {
				
				Automobile.PrintFile();
				
				} catch (Exception excpt) {
					System.out.println();
					System.out.println(excpt.getMessage());
					System.out.println("Failure.");
					System.out.println();
					Automobile.displayList();
					System.out.println();
				}
			}
		
		}
		while (!userInput.equalsIgnoreCase("quit"));
		
		System.out.println("Have a nice day!");
		in.close();
	}

}
