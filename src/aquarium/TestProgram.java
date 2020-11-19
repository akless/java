package aquarium;

/**
 * test program for the simulation of a virtual aquarium
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class TestProgram {

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
