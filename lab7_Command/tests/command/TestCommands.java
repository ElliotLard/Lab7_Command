package command;

import static org.junit.Assert.*;

import org.junit.Test;

import Weapon.ChainGun;
import Weapon.GenericWeapon;
import environment.Environment;
import exceptions.EnvironmentException;
import lifeform.MockLifeForm;

public class TestCommands
{

	/**
	 * LAB6 TESTS
	 */

	/**
	 * @author elliotlard
	 * 
	 *         tests the Acquire and Drop Commands
	 */
	@Test
	public void testAcquireAndDrop()
	{
		MockLifeForm bob = new MockLifeForm("bob", 1);
		GenericWeapon gun = new ChainGun();
		
		//creates an acquire and drop command
		Command acquire = new Acquire(bob, gun);
		Command drop = new Drop(bob);
		
		acquire.execute();
		//bob now has the gun
		assertEquals(gun, bob.getWeapon());
		drop.execute();
		//bob no longer has the gun
		assertNull(bob.getWeapon());
		
	}
	
	/**
	 * @author elliotlard
	 * 
	 *         tests the reload Command
	 */
	@Test
	public void testReload()
	{
		MockLifeForm bob = new MockLifeForm("bob", 1);
		
		// create a reload command
		Command reload = new Reload(bob);
		bob.pickup(new ChainGun());
		bob.getWeapon().shoot(5);
		reload.execute();
		//victim does not have max life and was succesfully attacked
		assertEquals(bob.getWeapon().getMaxAmmo(), bob.getWeapon().getAmmo());
	}
	
	/**
	 * @author elliotlard
	 * 
	 *         tests the attack Command
	 */
	@Test
	public void testAttack()
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		MockLifeForm victim = new MockLifeForm("victim", 10);
		world.addLifeForm(3, 0, bob);
		world.addLifeForm(3, 1, victim);
		bob.turn(Environment.EAST);

		// create an attack command
		Command attack = new Attack(bob);

		attack.execute();
		//victim does not have max life and was succesfully attacked
		assertTrue(victim.getMaxLifePoints() != victim.getLifePoints());
	}
	
	/**
	 * @author elliotlard
	 * 
	 *         tests the move Command
	 */
	@Test
	public void testMove()
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		world.addLifeForm(3, 0, bob);

		// create one move command
		Command move = new Move(bob);

		move.execute();
		//started 3 spots down and moved back to 0,0
		assertEquals(world.getCell(0,0), bob.getCell());
	}
	
	/**
	 * @author elliotlard
	 * 
	 *         tests each of the turn Commands
	 */
	@Test
	public void testTurn()
	{
		Environment world = Environment.getWorld();
		MockLifeForm bob = new MockLifeForm("bob", 1);
		world.addLifeForm(0, 0, bob);

		// create one of each of the turn commands
		Command turnNorth = new TurnNorth(bob);
		Command turnEast = new TurnEast(bob);
		Command turnSouth = new TurnSouth(bob);
		Command turnWest = new TurnWest(bob);

		// each command is called followed by a test asserting the turn actually
		// happened
		turnEast.execute();
		assertEquals(Environment.EAST, bob.getDirection());

		turnSouth.execute();
		assertEquals(Environment.SOUTH, bob.getDirection());

		turnWest.execute();
		assertEquals(Environment.WEST, bob.getDirection());

		turnNorth.execute();
		assertEquals(Environment.NORTH, bob.getDirection());
	}
}
