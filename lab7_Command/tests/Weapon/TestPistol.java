package Weapon;

import static org.junit.Assert.*;
import Weapon.GenericWeapon;
import Weapon.Pistol;

import org.junit.Test;

public class TestPistol {
	
	/**
	 * Lab 4 tests for Pistol
	 * @author Christopher Wilson
	 */

	
	/**
	 * Tests the creation and border cases of Pistol
	 */
	@Test
	public void testInit()
	{
		
		GenericWeapon pistol = new Pistol();
		
		assertEquals(12, pistol.calculateDamage(0)); // Tests at point blank
		assertEquals(0, pistol.calculateDamage(40)); // Tests at too far
		assertEquals(6, pistol.calculateDamage(13)); // Tests at mid range
	}
	
	/**
	 * Tests to make sure damage is correctly calculated with a Pistol and Scope
	 */
	@Test
	public void testPistolAndScope()
	{
		GenericWeapon p = new Pistol(); // Create pistol
		Attachment s = new Scope(p); // Create Scope
		
		assertEquals(9, s.calculateDamage(13)); 
	}
	
	/**
	 * Tests to make sure damage is correctly calculated with two scopes on a pistol
	 */
	@Test
	public void testPistolScopeAndScope()
	{
		GenericWeapon p = new Pistol(); // Create pistol
		Attachment s = new Scope(p); // Create first scope
		Attachment s1 = new Scope(s); // Create second scope
		
		assertEquals(14, s1.calculateDamage(13)); 
	}
	
	/**
	 * Another damage test using Scope and Stabilizer
	 */
	@Test
	public void testPistolScopeAndStabalizer()
	{
		GenericWeapon p = new Pistol(); // Create pistol
		Attachment s = new Scope(p); // Create Scope
		Attachment st = new Stabilizer(s); // Create Stabilizer
		
	
		assertEquals(11, st.calculateDamage(13));
	}
	
	/**
	 * Test using Scope and Power Booster with a pistol
	 */
	@Test
	public void testPistolScopeAndPowerBooster()
	{
		GenericWeapon p = new Pistol(); // Create Pistol
		Attachment s = new Scope(p); // Create Scope
		Attachment pb = new PowerBooster(s); // Create Power Booster
		
		
		assertEquals(18, pb.calculateDamage(13));
	}
}

