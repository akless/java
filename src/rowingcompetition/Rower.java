package rowingcompetition;

/**
 * simulation of a rower in a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class Rower {

	/* class variables */

	public static final int MINIMUM_POWER = 400;
	public static final int MAXIMUM_POWER = 500;
	
	/* object variables */
	
	private int power;
	
	/* constructor */
	
	public Rower() {
		this.setPower();
	}
	
	/* object methods */
	
	public int getPower() {
		return this.power;
	}
	
	public void setPower() {
		this.power = MINIMUM_POWER + (int) (Math.random() * 101);
	}

	@Override
	public String toString() {
		
		return "Rower with " + this.power + " watts";
	}
}
