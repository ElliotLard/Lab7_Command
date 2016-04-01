package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.ExceptionNegative;
import gameplay.SimpleTimer;
import recovery.RecoverFractional;
import recovery.RecoverLinear;
import recovery.RecoveryBehavior;

public class TestAlien
{
	/**
	 * LAB2 TESTS
	 * 
	 * @throws ExceptionNegative
	 */
	@Test
	public void testConstruction() throws ExceptionNegative// constructs with
															// name and hp
	{
		Alien zorg = new Alien("Zorg", 30);
		assertEquals(zorg.getName(), "Zorg");
		assertEquals(zorg.getLifePoints(), 30);
	}

	@Test
	public void testRecoverLinear() throws ExceptionNegative// recoverLinear
															// works correctly
	{
		RecoveryBehavior rb = new RecoverLinear(5);
		Alien zorg = new Alien("Zorg", 30, rb);
		zorg.takeHit(20);
		zorg.recover();
		assertEquals(15, zorg.currentLP);
	}

	@Test // recoverFractional works correctly
	public void testRecoverFractional() throws ExceptionNegative
	{
		RecoveryBehavior rb = new RecoverFractional(50);
		Alien zorg = new Alien("Zorg", 30, rb);
		zorg.takeHit(20);
		zorg.recover();
		assertEquals(15, zorg.currentLP);
	}

	/**
	 * LAB3 TESTS
	 * 
	 * @throws ExceptionNegative
	 * @throws EnvironmentException 
	 */
	@Test // attackStrength should default to 10 for aliens
	public void testAlienAttacks() throws ExceptionNegative, EnvironmentException
	{
		Environment.getWorld();
		Alien zorg = new Alien("Zorg", 30);
		Alien zod = new Alien("Zod", 30);
		zorg.move(0,1);
		zod.move(0,0);
		assertEquals(10, zorg.getAttackStrength());
		zorg.attack(zod);
		assertEquals(20, zod.getLifePoints());

	}

	@Test // recovers health on even numbered rounds when the recoveryRate is 2
	public void testAlienRecoverRate() throws ExceptionNegative
	{
		Alien zorg = new Alien("Zorg", 30, new RecoverLinear(10), 10, 2);
		zorg.takeHit(20);
		zorg.updateTime(4);
		assertEquals(20, zorg.getLifePoints());// recovers successfully
		zorg.setRecoverRate(3);
		assertEquals(3, zorg.getRecoverRate());// recoverRate successfully
												// changed to 3
	}

	@Test // recovers health on even numbered rounds when the recoveryRate is 2
	public void testRecoverRate() throws ExceptionNegative
	{
		Alien zorg = new Alien("Zorg", 30, new RecoverLinear(10), 10, 2);
		SimpleTimer t = new SimpleTimer(1000);
		t.addTimeObserver(zorg);
		zorg.takeHit(15);
		assertEquals(15, zorg.getLifePoints());// takes 15 damage
		t.timeChanged();
		assertEquals(15, zorg.getLifePoints());// hasn't healed yet
		t.timeChanged();
		assertEquals(25, zorg.getLifePoints());// recovers 10 health
	}

	@Test // recovers health on even numbered rounds when the recoveryRate is 2
	public void testRecoverRateNot2() throws ExceptionNegative
	{
		Alien zorg = new Alien("Zorg", 30, new RecoverLinear(10), 10, 3);
		SimpleTimer t = new SimpleTimer(1000);
		t.addTimeObserver(zorg);
		zorg.takeHit(15);
		assertEquals(15, zorg.getLifePoints());// takes 15 damage
		t.timeChanged();
		assertEquals(15, zorg.getLifePoints());// hasn't healed yet
		t.timeChanged();
		assertEquals(15, zorg.getLifePoints());// still hasn't healed
		t.timeChanged();
		assertEquals(25, zorg.getLifePoints());// heals now
	}

	@Test // Doesn't recover when recoveryRate is 0
	public void testRecoverRateZero() throws ExceptionNegative
	{
		Alien zorg = new Alien("Zorg", 30, new RecoverLinear(10), 10, 0);
		SimpleTimer t = new SimpleTimer(1000);
		t.addTimeObserver(zorg);
		zorg.takeHit(15);
		assertEquals(15, zorg.getLifePoints());// takes 15 damage
		t.timeChanged();
		assertEquals(15, zorg.getLifePoints());// doesnt heal

	}

	@Test // doesn't recover when removed from t
	public void testRemoveObserver() throws ExceptionNegative
	{
		Alien zorg = new Alien("Zorg", 30, new RecoverLinear(10), 10, 1);
		SimpleTimer t = new SimpleTimer(1000);
		t.addTimeObserver(zorg);
		zorg.takeHit(15);
		assertEquals(15, zorg.getLifePoints());// takes 15 damage
		t.timeChanged();
		assertEquals(25, zorg.getLifePoints());// heals for 10
		t.removeTimeObserver(zorg);
		t.timeChanged();
		assertEquals(25, zorg.getLifePoints());// doesn't heal

	}
}
