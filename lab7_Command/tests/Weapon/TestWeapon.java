package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ExceptionNegative;
import lifeform.Alien;

public class TestWeapon
{
	/**
	 * LAB4 TESTS author Elliot Lard
	 */
	@Test
	public void test() throws ExceptionNegative
	{
		GenericWeapon chainGun = new ChainGun();// constructs with a given base
												// damage
		assertEquals(15, chainGun.calculateDamage(30)); // does full damage at
														// max range.
		assertEquals(7, chainGun.calculateDamage(15)); // does half damage when
														// at half of max range.
		assertEquals(0, chainGun.calculateDamage(35)); // does no damage when
														// out of range.
		chainGun.shoot(5);
		assertEquals(39, chainGun.getAmmo()); // lost 1 ammo after being fired

		for (int x = 0; x < 39; x++)
			chainGun.shoot(5);
		assertEquals(0, chainGun.getAmmo()); // lost 1 ammo after being fired
		assertEquals(0, chainGun.shoot(5));// does no damage when at 0 ammo.

	}

}
