package gui;

import static org.junit.Assert.assertEquals;

import environment.Environment;
import exceptions.EnvironmentException;
import gameplay.SimpleTimer;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class Runner
{
	/**
	 * This is the file you actually run to make the game board happen.
	 * The JUnit tests are a little weird and won't keep the window
	 * open just calling on the main method.
	 * 
	 * If you want to pre-place anything to try out the board you'll
	 * have to make an object and input it using this method, saving the
	 * GUI instantiation for last.
	 * @param argc
	 */
	public static void main(String argc[])
	{
		SimpleTimer time = new SimpleTimer();
		LifeForm player = new Human("bob", 10,10);
		Environment.getWorld().addLifeForm(5, 5, player);
		InvokerBuilder commands = new InvokerBuilder(player);
		commands.main(argc);
		GUI window = new GUI();
		time.addTimeObserver(window);
		time.addTimeObserver(player);
		time.run();
	}
}

