package aquarium;

/**
 * simulation of a virtual aquarium
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class Aquarium {

	/* object variables */
	
	private Fish[] fishes;
	private int width;
	private int height;
	
	/* constructor */
	
	public Aquarium(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		fishes = new Fish[0];
	}
	
	/* object methods */
	
	public void addFish(Fish fish) {
		
		Fish[] fishes = new Fish[this.fishes.length + 1];
		
		for (int i = 0; i < this.fishes.length; i++)
			fishes[i] = this.fishes[i];
		
		fishes[fishes.length - 1] = fish;
		
		this.fishes = fishes;
	}

	public void next() {
		
		for (int i = 0; i < this.fishes.length; i++) {
			
			Fish fish = this.fishes[i];
			
			if (fish == null)
				continue;
			
			fish.swim(this);
		}
		
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
				
		String str = "";
		
		for (int y = 0; y < this.height; y++) {
			str += "|";
			for (int x = 0; x < this.width; x++) {
				Fish fish = getFish(x, y);
				if (fish != null) {
					str += fish;
					x += fish.length() - 1;
				}
				else
					str += " ";
			}
			str += "|\n";
		}
		
		str += "+";
		for (int x = 0; x < width; x++)
			str += "-";
		str += "+\n";
		
		return str;
	}
	
	private Fish getFish(int x, int y) {
		
		for (int i = 0; i < this.fishes.length; i++)
			if (this.fishes[i].getX() == x && this.fishes[i].getY() == y)
				return fishes[i];
		
		return null;
	}
	
	/* class methods */
	
	/** test program for he simulation of a virtual aquarium */
	public static void main(String[] args) throws InterruptedException {
		
		Aquarium aquarium = new Aquarium(28, 4);
		
		aquarium.addFish(new Fish( 0, 3, false));
		aquarium.addFish(new Fish( 7, 0,  true));
		aquarium.addFish(new Fish(17, 1, false));
		aquarium.addFish(new Fish(25, 2,  true));
		
		while (true) {
			System.out.println(aquarium);
			Thread.sleep(300);
			aquarium.next();
		}
	}	
}
