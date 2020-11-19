package rowingcompetition;

/**
 * simulation of a boat in a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public abstract class Boat {

	/* object attributes */
	
	private Rower[] rowers;
	private int overallPower;
	private int x;
	private String top1;
	private String top2;
	private String middle;
	private String bottom1;
	private String bottom2;
	private boolean phase;
	
	/* constructor */
	
	public Boat(int amountOfRowers, String top1, String top2, String middle, String bottom1, String bottom2) {
		
		this.rowers = new Rower[amountOfRowers];
		
		for (int i = 0; i < this.rowers.length; i++) {
			this.rowers[i] = new Rower();
			this.overallPower += rowers[i].getPower();
		}
		
		this.top1 = top1;
		this.top2 = top2;
		this.middle = middle;
		this.bottom1 = bottom1;
		this.bottom2 = bottom2;
	}
	
	/* object methods */
	
	public void rowing() {
		
		//------------------------------------------------------------------------
		// daily form changes with every row (makes the race more interesting)
		this.overallPower = 0;
		for (Rower r : rowers) {
			r.setPower();
			this.overallPower += r.getPower();
		}
		//------------------------------------------------------------------------
		
		this.x += Math.ceil((double) (this.overallPower - (Rower.MINIMUM_POWER * this.rowers.length)) / (double) (Rower.MAXIMUM_POWER - Rower.MINIMUM_POWER));
		this.phase = !this.phase;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getLength() {
		return this.middle.length();
	}
	
	@Override
	public String toString() {
		String str = "";
		str += " ".repeat(this.x) + (this.phase ? this.top1 : this.top2) + "\n";
		str += " ".repeat(this.x) + this.middle + "\n";
		str += " ".repeat(this.x) +(this.phase ? this.bottom1 : this.bottom2) + "\n";
		return str;
	}
}
