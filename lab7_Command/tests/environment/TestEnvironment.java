package environment;

import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * Tests for the Environment class.
 */
import static org.junit.Assert.*;
//import static org.junit.Assert.assertNull;

import org.junit.Test;

import Weapon.GenericWeapon;
import Weapon.Pistol;
import exceptions.EnvironmentException;

public class TestEnvironment
{
	/**
	 * LAB6 TESTS
	 */

	/**
	 * @author elliotlard
	 * 
	 *         tests to ensure lifeForm moves and turns properly when there is
	 *         nothing in it's way
	 * 
	 * @throws EnvironmentException
	 */
	@Test
	public void testMoveLifeFormSimple() throws EnvironmentException
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		world.addLifeForm(0, 0, bob);

		bob.turn(Environment.EAST);
		world.moveLifeForm(bob);
		// moved 3 spaces to the east
		assertEquals(world.getCell(0, 3), bob.getCell());

		// leaves behind an empty cell after movement
		assertNull(world.getCell(0, 0).getLifeForm());

		bob.turn(Environment.WEST);
		world.moveLifeForm(bob);
		// moved 3 spaces to the west
		assertEquals(world.getCell(0, 0), bob.getCell());

		bob.turn(Environment.SOUTH);
		world.moveLifeForm(bob);
		// moved 3 spaces to the south
		assertEquals(world.getCell(3, 0), bob.getCell());

		bob.turn(Environment.NORTH);
		world.moveLifeForm(bob);
		// moved 3 spaces to the north
		assertEquals(world.getCell(0, 0), bob.getCell());
	}

	/**
	 * @author elliotlard
	 * 
	 *         tests to ensure lifeForm constructs with proper direction and
	 *         maxSpeed and the direction can be changed. And movement is
	 *         properly stopped by the bounds of the Environment
	 */
	@Test
	public void testMoveLifeFormRestrictions() throws EnvironmentException
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		world.addLifeForm(0, 0, bob);

		// constructs properly with a speed of 3 and facing north
		assertEquals(3, bob.getMaxSpeed());
		assertEquals(Environment.NORTH, bob.getDirection());

		world.moveLifeForm(bob);
		// stays in the same spot since at the north edge of the screen and
		// facing north
		assertEquals(world.getCell(0, 0), bob.getCell());
		bob.turn(Environment.WEST);
		world.moveLifeForm(bob);
		// stays in the same spot since at the west edge of the screen and
		// facing west
		assertEquals(world.getCell(0, 0), bob.getCell());

		bob.move(Environment.HEIGHT - 1, Environment.WIDTH - 1);// now in the
																// southeast
																// corner
		bob.turn(Environment.EAST);
		// stays in the same spot since at the east edge of the screen and
		// facing east
		assertEquals(world.getCell(Environment.HEIGHT - 1, Environment.WIDTH - 1), bob.getCell());
		bob.turn(Environment.SOUTH);
		// stays in the same spot since at the south edge of the screen and
		// facing south
		assertEquals(world.getCell(Environment.HEIGHT - 1, Environment.WIDTH - 1), bob.getCell());
	}

	/**
	 * @author elliotlard
	 * 
	 *         tests different situations of lifeForms being able to jump over
	 *         and be blocked by each other as well as this combined with being
	 *         blocked by the bounds of the environment.
	 */
	@Test
	public void testMoveLifeFormComplicated() throws EnvironmentException
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		MockLifeForm dummy1 = new MockLifeForm("dummy1", 1);
		MockLifeForm dummy2 = new MockLifeForm("dummy2", 1);
		MockLifeForm dummy3 = new MockLifeForm("dummy3", 1);
		world.addLifeForm(0, 3, dummy1);
		world.addLifeForm(2, 2, dummy2);
		world.addLifeForm(3, 2, dummy3);
		// bob # # dummy1
		// # # # #
		// # # dummy2 #
		// # # dummy3 #

		world.addLifeForm(0, 0, bob);
		bob.turn(Environment.EAST);
		world.moveLifeForm(bob);
		// # # bob dummy1
		// # # # #
		// # # dummy2 #
		// # # dummy3 #
		// only moved 2 cells because dummy1 was in the third
		assertEquals(world.getCell(0, 2), bob.getCell());

		bob.turn(Environment.SOUTH);
		world.moveLifeForm(bob);
		// # # # dummy1
		// # # bob #
		// # # dummy2 #
		// # # dummy3 #
		// only moved 1 cell because dummies were in the 2nd and 3rd.
		assertEquals(world.getCell(1, 2), bob.getCell());

		dummy2.turn(Environment.NORTH);
		world.moveLifeForm(dummy2);
		// # # dummy2 dummy1
		// # # bob #
		// # # # #
		// # # dummy3 #
		// dummy2 jumps over bob but is unable to move further because of the
		// wall
		assertEquals(world.getCell(0, 2), dummy2.getCell());

	}

	/**
	 * end lab 6
	 */

	/**
	 * tests the Environment constructor
	 */
	@Test
	public void testConstruction()
	{
		for (int x = 0; x < Environment.HEIGHT; x++)
		{
			for (int y = 0; y < Environment.WIDTH; y++)
			{
				assertTrue(Environment.getWorld().getCell(x, y) != null);
			}
		}
	}

	/**
	 * ##############################
	 */
	@Test
	public void testHoldsWeapon()
	{
		GenericWeapon w = new Pistol();
		Environment.getWorld().getCell(3, 5).addWeapon(w);

		// first weapon added is the pistol;
		assertEquals(w, Environment.getWorld().getCell(3, 5).getWeapon(0));
		Environment.getWorld().getCell(3, 5).removeWeapon(w);

		// size of weapons is 0 because we removed the weapon
		assertEquals(0, Environment.getWorld().getCell(3, 5).getWeapons().size());
	}

	/**
	 * ensures that the distance function works properly
	 * 
	 * @throws EnvironmentException
	 */
	@Test
	public void testDistanceFinder() throws EnvironmentException
	{
		LifeForm bob = new Human("bob", 30);
		LifeForm fred = new Human("fred", 30);
		bob.move(Environment.getWorld().getCell(0, 5));
		fred.move(Environment.getWorld().getCell(0, 1));
		// correct distance when in same row
		assertEquals(20, Environment.getDistance(bob.getCell(), fred.getCell()));
		bob.move(5, 1);
		// correct distance when in same column
		assertEquals(25, Environment.getDistance(bob.getCell(), fred.getCell()));
		fred.move(8, 3);
		// correct distance when in a different row and column
		assertEquals(18, Environment.getDistance(bob.getCell(), fred.getCell()));

	}

	/**
	 * LAB1 TESTS
	 */

	@Test
	public void testHoldsLife()
	{
		MockLifeForm bob = new MockLifeForm("Bob", 10);
		Environment.getWorld().addLifeForm(1, 0, bob);
		assertTrue(Environment.getWorld().getLifeForm(1, 0) == (bob));
	}

	@Test
	public void testRemoveLife()
	{
		MockLifeForm bob = new MockLifeForm("Bob", 10);
		Environment.getWorld().addLifeForm(1, 0, bob);
		assertTrue(Environment.getWorld().getLifeForm(1, 0) == (bob));
		Environment.getWorld().removeLifeForm(1, 0);
		assertTrue(Environment.getWorld().getLifeForm(1, 0) == null);

	}

}
