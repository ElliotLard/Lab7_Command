package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;

public class TestHuman
{
	
	/**
	 * LAB6 TESTS
	 */
	
	@Test
	public void testMoveConstruction()// constructs with name, hp, and armor
	{
		Human bob = new Human("Bob", 40, 5);
		
		//bob starts facing north with 3 maxSpeed
		assertEquals(Environment.NORTH, bob.getDirection());
		assertEquals(3, bob.getMaxSpeed());
	}
	
	/**
	 * LAB2 TESTS
	 */
	@Test
	public void testConstruction()// constructs with name, hp, and armor
	{
		Human bob = new Human("Bob", 40, 5);
		assertEquals(bob.getName(), "Bob");
		assertEquals(bob.getLifePoints(), 40);
		assertEquals(bob.getArmor(), 5);
		Human fred = new Human("Fred", 40, -5);
		assertEquals(fred.getArmor(), 0);
	}

	@Test
	public void testArmor()// tests set and get armor
	{
		Human bob = new Human("Bob", 40, 5);
		assertEquals(bob.getArmor(), 5);
		bob.setArmor(10);
		assertEquals(bob.getArmor(), 10);
		bob.setArmor(-5);
		assertEquals(bob.getArmor(), 0);// armor cannot be < 0
	}

	/**
	 * LAB3 TESTS
	 * @throws EnvironmentException 
	 */
	@Test
	public void testHumanAttacks() throws EnvironmentException// humans with no armor take attack and take
									// damage
	{
		Environment.getWorld();
		Human bob = new Human("Bob", 40);
		Human fred = new Human("Fred", 40);
		bob.move(0,0);
		fred.move(1,0);
		assertEquals(bob.getAttackStrength(), 5);
		bob.attack(fred);
		assertEquals(fred.getLifePoints(), 35);
	}

	@Test
	public void testArmorAbsorbs() throws EnvironmentException// humans with armor take reduced damage
	{
		Environment.getWorld();
		Human bob = new Human("Bob", 40, 3);
		Human fred = new Human("Fred", 40, 10);
		Human george = new Human("George", 40, 10, 10);
		bob.move(4,4);
		fred.move(4,5);
		george.move(4,6);
		fred.attack(bob);
		assertEquals(bob.getLifePoints(), 38); // damage is reduced by 3 from
												// armor
		bob.attack(fred);
		assertEquals(fred.getLifePoints(), 40); // takes no damage because the
												// armor is greater than the
												// attack
		george.attack(fred);
		assertEquals(fred.getLifePoints(), 40); // fred takes no damage because
												// george's attack damage and
												// fred's armor are equal

	}

}
