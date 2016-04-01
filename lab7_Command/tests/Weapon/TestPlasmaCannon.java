package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlasmaCannon
{

	@Test
	public void testChainGunMaxRange()
	{
		GenericWeapon p = new PlasmaCannon();
		assertEquals(50, p.shoot(20));
		assertEquals(20,p.getRange());
		assertEquals(0, p.shoot(21));
	}

}
