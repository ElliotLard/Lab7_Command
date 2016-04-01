package environment;

import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * Tests for the Environment class.
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Weapon.GenericWeapon;
import Weapon.Pistol;
import exceptions.EnvironmentException;

public class TestEnvironment
{
	/**
	 * LAB5 TESTS
	 */
	
	/**
	 * tests the Environment constructor
	 */
	@Test
	public void testConstruction()
	{
		for(int x = 0;x < Environment.HEIGHT;x++)
		{
			for(int y = 0;y < Environment.WIDTH;y++)
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
		
		//first weapon added is the pistol;
		assertEquals(w, Environment.getWorld().getCell(3, 5).getWeapon(0));
		Environment.getWorld().getCell(3, 5).removeWeapon(w);
		
		//size of weapons is 0 because we removed the weapon
		assertEquals(0, Environment.getWorld().getCell(3, 5).getWeapons().size());
	}
	
	/**
	 * ensures that the distance function works properly
	 * @throws EnvironmentException 
	 */
	@Test
	public void testDistanceFinder() throws EnvironmentException
	{
		LifeForm bob = new Human("bob", 30);
		LifeForm fred = new Human("fred", 30);
		bob.move(Environment.getWorld().getCell(0,  5));
		fred.move(Environment.getWorld().getCell(0, 1));
		//correct distance when in same row
		assertEquals(20, Environment.getDistance(bob.getCell(), fred.getCell()));
		bob.move(5, 1);
		//correct distance when in same column
		assertEquals(25, Environment.getDistance(bob.getCell(), fred.getCell()));
		fred.move(8, 3);
		//correct distance when in a different row and column
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
