package rowingcompetition;

/**
 * test program for the simulation of a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class TestProgram {

	/* class variables */
	
	private static java.util.Scanner sc = new java.util.Scanner(System.in);
	
	/* class methods */
	
	public static void main(String[] args) throws InterruptedException {
		
		int amountOfBoats;
		int amountOfRowers;
		int distance;
		
		System.out.print("How many boats? ");
		amountOfBoats = sc.nextInt();
		if (amountOfBoats < 1)
			invalidInput();
		
		System.out.print("2 or 4 rowers? ");
		amountOfRowers = sc.nextInt();
		if (amountOfRowers != 2 && amountOfRowers != 4)
			invalidInput();
		
		System.out.print("Which distance? ");
		distance = sc.nextInt();
		if (distance <= 0)
			invalidInput();
		
		sc.close();
		
		new Simulation(amountOfBoats, amountOfRowers, distance).competition();
	}
	
	private static void invalidInput() {
		sc.close();
		throw new IllegalArgumentException("Invalid input");
	}
}
