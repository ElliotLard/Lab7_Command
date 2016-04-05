package lifeform;

/**
 * tests the LifeForm class
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Weapon.ChainGun;
import Weapon.GenericWeapon;
import environment.Environment;
import exceptions.EnvironmentException;

public class TestLifeForm
{

	/**
	 * LAB5 TESTS author Elliot Lard
	 */
	
	/**
	 * LAB4 TESTS author Elliot Lard
	 * @throws EnvironmentException 
	 */
	@Test
	public void testWeaponHandling() throws EnvironmentException
	{
		MockLifeForm bob, fred;
		bob = new MockLifeForm("Bob", 40);
		fred = new MockLifeForm("Fred", 40);
		bob.move(Environment.getWorld().getCell(5, 5));
		fred.move(5, 15);
		
		GenericWeapon gun = new ChainGun();
		GenericWeapon gun2 = new ChainGun();

		bob.pickup(gun);
		assertEquals(gun, bob.getWeapon()); // successfully picked up the gun
		bob.pickup(gun2);
		assertEquals(gun, bob.getWeapon()); // can't pickup another gun

		bob.attack(fred);
		assertEquals(gun.getMaxAmmo() - 1, gun.getAmmo()); // one fewer ammo
		bob.reload();
		assertEquals(gun.getMaxAmmo(), gun.getAmmo()); // now has full ammo
														// after reloading
		bob.dropGun();
		assertEquals(null, bob.getWeapon()); // dropped gun
	}

	@Test
	public void testAttackHandling() throws EnvironmentException
	{

		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		MockLifeForm victim = new MockLifeForm("Fred", 40);
		entity.move(Environment.getWorld().getCell(5, 4));
		victim.move(5, 5); //now 5 ft away
		GenericWeapon gun = new ChainGun();
		entity.pickup(gun);

		entity.attack(victim);

		// correctly took damage from the gun.
		assertEquals(victim.getMaxLifePoints() - gun.calculateDamage(5), victim.getLifePoints());
		
		entity.move(5, 12);//now 35 ft away
		
		for (int x = 0; x < 39; x++)
		{
			entity.attack(victim);
		}

		// has same amount of health as before because victim was out of range
		// ammo should now be at 0
		assertEquals(victim.getMaxLifePoints() - gun.calculateDamage(5), victim.getLifePoints());
		
		entity.move(5, 10);//now 25 ft away
		entity.attack(victim);

		entity.move(5, 6);//now 5 ft away
		// same life as before because ammo is empty and range is too far for a
		// basic attack
		assertEquals(victim.getMaxLifePoints() - gun.calculateDamage(5), victim.getLifePoints());
		entity.attack(victim);

		// health is now reduced by the attackStrength of entity because ammo
		// was out of ammo but was within basic attack range
		assertEquals(victim.getMaxLifePoints() - (gun.calculateDamage(5) + entity.getAttackStrength()), victim.getLifePoints());
	}

	/**
	 * LAB1 TESTS
	 * 
	 */

	/**
	 * When a LifeForm is created, it should know its name and how many life
	 * points it has.
	 */
	@Test
	public void testInitialization()// constructor works properly
	{
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getLifePoints());
	}

	@Test
	public void testTakeHit()// takes damage properly
	{
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		entity.takeHit(20);
		assertEquals(20, entity.getLifePoints());
	}

	/**
	 * LAB3 TESTS
	 */

	@Test
	public void testSetAndGetAttackStrength()
	{
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40, 20);
		assertEquals(20, entity.getAttackStrength()); // getAttackStrength works
		entity.setAttackStrength(10);
		assertEquals(10, entity.getAttackStrength()); // setAttackStrength works
														// properly
	}

	@Test
	public void testAttack() throws EnvironmentException // tests the attack method
	{
		Environment.getWorld();
		MockLifeForm bob, fred;
		bob = new MockLifeForm("Bob", 40, 20);
		fred = new MockLifeForm("Fred", 40, 20);
		bob.move(5,10);
		fred.move(6,10);
		bob.attack(fred);
		bob.attack(fred);
		assertEquals(0, fred.getLifePoints());// fred was attacked twice for 20
												// each
		fred.attack(bob);
		assertEquals(40, bob.getLifePoints());// fred should deal no damage
												// because his health is at 0
	}
}
