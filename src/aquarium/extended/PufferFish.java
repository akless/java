package aquarium.extended;

import aquarium.Aquarium;
import aquarium.Fish;

/**
 * simulation of a puffer fish in a virtual aquarium
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class PufferFish extends Fish {

	/* constructor */
	
	public PufferFish(int x, int y, boolean direction) {
		super(x, y, "<()><", "><()>", direction);
	}

	/* object methods */

	public void swim(Aquarium aquarium) {		
		
		super.swim(aquarium);
		
		if ((int)(Math.random() * 10) == 0) {
			if ((int)(Math.random() * 2) == 0) {
				if (this.y > 0)
					this.y--;
			}
			else {
				if (this.y < aquarium.getHeight() - 1)
					this.y++;
			}
		}
	}
}
