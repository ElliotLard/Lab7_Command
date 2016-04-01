package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStabilizer
{

	/**
	 * LAB4 TESTS author Elliot Lard
	 */
	@Test
	public void testStabilizerWithChaingun()
	{
		GenericWeapon c = new ChainGun();
		Attachment s = new Stabilizer(c);

		assertEquals(18, s.calculateDamage(30));
	}

	@Test
	public void testStabilizerWithStabilizerWithChaingun()
	{
		GenericWeapon c = new ChainGun();
		Attachment s1 = new Stabilizer(c);
		Attachment s2 = new Stabilizer(s1);

		assertEquals(22, s2.calculateDamage(30));
	}

	@Test
	public void testReload()
	{
		GenericWeapon c = new ChainGun();
		Attachment s1 = new Stabilizer(c);

		s1.shoot(10);

		assertEquals(s1.getMaxAmmo() - 1, s1.getAmmo());
		for (int x = 0; x < 39; x++)
		{
			s1.shoot(10);
		}
		assertEquals(s1.getMaxAmmo(), s1.getAmmo());

	}

}
