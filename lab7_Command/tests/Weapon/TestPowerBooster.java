package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPowerBooster
{

	@Test
	public void testPowerBoosterrWithPlasmaCannon()
	{
		GenericWeapon p = new PlasmaCannon();
		Attachment pb = new PowerBooster(p);

		assertEquals(100, pb.shoot(20));
	}

	@Test
	public void testPowerBoosterWithPowerBoosterWithPlasmaCannon()
	{
		GenericWeapon p = new PlasmaCannon();
		Attachment pb1 = new PowerBooster(p);
		Attachment pb2 = new PowerBooster(pb1);

		assertEquals(200, pb2.calculateDamage(20));
	}

	@Test
	public void testShotPower()
	{
		GenericWeapon p = new PlasmaCannon();
		Attachment pb = new PowerBooster(p);

		assertEquals(pb.getMaxAmmo(), pb.getAmmo());
		for (int x = 0; x < 4; x++)
		{
			pb.shoot(10);
		}
		assertEquals(0, pb.shoot(10));

	}

}
