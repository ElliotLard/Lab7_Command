package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestScope
{
	/**
	 * Scope Test for Lab 4
	 * @author Christopher Wilson
	 */
	
	/**
	 * This test is only to make sure scope is properly initialized
	 * with a weapon and then returns ONLY the damage done by Scope
	 */
	@Test
	public void testScopeWithPistol()
	{
		GenericWeapon p = new Pistol(); // Creates Pistol
		Attachment s = new Scope(p); // Creates Scope
		
		/**
		 * Pistol damage alone at a distance of 13 should be 6.
		 * Adding that to our scope damage calculation we should
		 * end up with a value of 3
		 */
		assertEquals(9, s.calculateDamage(13));
	}
}
