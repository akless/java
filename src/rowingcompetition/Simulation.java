package rowingcompetition;

/**
 * simulation of a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class Simulation {

	/* object variables */
	
	private Boat[] boats;
	private int distance;
	
	/* constructor */
	
	public Simulation(int amountOfBoats, int amountOfRowers, int distance) {
		
		this.boats = new Boat[amountOfBoats];
		
		for (int i = 0; i < this.boats.length; i++)
			this.boats[i] = amountOfRowers == 2 ? new TwoPersonBoat() : new FourPersonBoat();
		
		this.distance = distance;
	}
	
	/* object methods */
	
	public void competition() throws InterruptedException {
		
		while (!goalAchieved()) {
			System.out.println("-".repeat(this.distance + boats[0].getLength() - 1) + "| Goal");
			for (Boat boot : boats) {
				boot.rowing();
				System.out.print(boot);
			}
			Thread.sleep(300);
		}
	}
	
	private boolean goalAchieved() {
		
		for (Boat boot : boats)
			if (boot.getX() >= this.distance)
				return true;
		
		return false;
	}
}
