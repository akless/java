package aquarium.extended;

import aquarium.Aquarium;
import aquarium.Fish;

/**
 * test program for the simulation of the extended virtual aquarium
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class TestProgram {

	public static void main(String[] args) throws InterruptedException {
		
		Aquarium aquarium = new Aquarium(40, 10);
		
		aquarium.addFish(new Fish( 0, 8, false));
		aquarium.addFish(new Fish( 7, 1, true));
		aquarium.addFish(new Fish(17, 3, false));
		aquarium.addFish(new Fish(25, 5, true));
		
		aquarium.addFish(new Shark(28, 2, false));
		aquarium.addFish(new PufferFish(15, 7, true));
		aquarium.addFish(new Swordfish( 3, 5, true));
		
		while (true) {
			System.out.println(aquarium);
			Thread.sleep(300);
			aquarium.next();
		}
	}
}
