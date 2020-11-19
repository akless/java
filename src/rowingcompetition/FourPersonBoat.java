package rowingcompetition;

/**
 * simulation of a 4-person boat in a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class FourPersonBoat extends Boat {

	public FourPersonBoat() {
		super(4,
				"     / /     ",
				"     \\ \\     ",
				"<--o-o-o-o-->",
				"   \\     \\   ",
				"   /     /   ");
	}
}
