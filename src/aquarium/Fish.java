package aquarium;

/**
 * simulation of a fish in a virtual aquarium
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class Fish {

	/* object variables */
	
	protected int x;
	protected int y;
	private String left;
	private String right;
	public boolean direction;

	/* constructors */
	
	public Fish(int x, int y, boolean direction) {
		this(x, y, "<><", "><>", direction);
	}
	
	protected Fish(int x, int y, String left, String right, boolean direction) {
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.direction = direction;
	}
	
	/* object methods */

	public void swim(Aquarium aquarium) {		
		if ((this.x == 0 && !direction) || this.x == aquarium.getWidth() - this.length() && direction)
			this.direction = !this.direction;
		else
			x = this.direction ? x + 1 : x - 1;
	}
	
	public int length() {
		return (direction ? right : left).length();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getLeft() {
		return left;
	}

	public String getRight() {
		return right;
	}

	public boolean getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		return direction ? right : left;
	}
	
}
