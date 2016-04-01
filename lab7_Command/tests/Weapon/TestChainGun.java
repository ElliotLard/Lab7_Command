package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChainGun
{
	/**
	 * LAB4 TESTS author Elliot Lard
	 */
	@Test
	public void testChainGunMaxRange()
	{
		GenericWeapon c = new ChainGun();
		assertEquals(15, c.calculateDamage(30));
	}

}
