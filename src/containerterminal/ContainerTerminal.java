package containerterminal;

/**
 * simulation of a container terminal
 * @author André Kless <andre.kless@web.de>
 * @version 1.0.0
 */
public class ContainerTerminal {

	/* object attributes */

	private int crane;			// position of the crane
	private int max;			// maximum height of a stack
	private int[] stack;		// contains the height of each stack
	private boolean container;	// crane has picked up a container

	/* constructor */

	public ContainerTerminal(int crane, int max, int[] stack) {
		this.crane = crane;
		this.max = max;
		this.stack = stack;
		this.container = false;
	}

	/* object methods */

	/** moves the crane one position to the left, if possible */
	public void moveLeft() {
		if (this.crane > 0)
			this.crane--;
		else
			System.out.println("Kran kann nicht weiter nach links bewegt werden.");
	}

	/** moves the crane one position to the right, if possible */
	public void moveRight() {
		if (this.crane < this.stack.length - 1)
			this.crane++;
		else
			System.out.println("The crane cannot be moved any further to the right.");
	}

	/** picks up a container from a stack with the crane, if possible */
	public void pickUpContainer() {
		if (this.container)
			System.out.println("The crane already has a container.");
		else if (this.stack[crane] == 0)
			System.out.println("The stack is empty.");
		else {
			this.stack[this.crane]--;
			this.container = true;
		}
	}

	/** the crane places a container on top of a stack, if possible */
	public void placeContainer() {
		if (!this.container)
			System.out.println("The crane does not have a container.");
		else if (this.stack[crane] == this.max)
			System.out.println("The stack has already reached its maximum height.");
		else {
			this.stack[this.crane]++;
			this.container = false;
		}
	}
	
	@Override
	public String toString() {
		String str = "Container Terminal\n";

		// first line (crane)
		for (int i = 0; i < this.stack.length; i++)
			str += this.crane == i ? " ^" : "  ";
		str += '\n';

		// second line (container, if available)
		for (int i = 0; i < this.stack.length; i++)
			str += this.crane == i && this.container ? " □" : "  ";
		str += '\n';

		// more lines (container stacks)
		for (int i = this.max - 1; i >= 0; i--) {
			for (int j = 0; j < this.stack.length; j++)
				str += this.stack[j] > i ? " □" : "  ";
			str += '\n';
		}

		return str;
	}

	/* class methods */

	/** Test program for the container terminal */
	public static void main(String[] args) {

		int[] values = new int[] {1, 2, 1, 3, 2};
		ContainerTerminal terminal = new ContainerTerminal(2, 3, values);
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Legende");
		System.out.println("^: Crane");
		System.out.println("□: Container");
		while (true) {
			System.out.println();
			System.out.println(terminal);
			System.out.println("Menu");
			System.out.println("W: Pick up");
			System.out.println("A: Left");
			System.out.println("S: Lay down");
			System.out.println("D: Right");
			System.out.println("X: Quit");
			System.out.println();
			System.out.print("Command: ");
			switch (sc.next()) {
			case "w":
				terminal.pickUpContainer();
				break;
			case "a":
				terminal.moveLeft();
				break;
			case "s":
				terminal.placeContainer();
				break;
			case "d":
				terminal.moveRight();
				break;
			case "x":
				System.out.println("\nProgram ended.");
				sc.close();
				return;
			}
		}
	}
}