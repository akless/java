package rowingcompetition;

/**
 * simulation of a 2-person boat in a rowing competition
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class TwoPersonBoat extends Boat {

	public TwoPersonBoat() {
		super(2,
				"   / /   ",
				"   \\ \\   ",
				"<--o-o-->",
				"   / /   ",
				"   \\ \\   ");
	}
}
