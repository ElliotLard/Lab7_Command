package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryLinear
{
	/**
	 * LAB2 TESTS
	 */
	@Test
	public void testRecoverFullHealth()// already full health
	{
		RecoveryBehavior rLinear = new RecoverLinear(3);
		int maxLifePts = 30;
		int result = rLinear.calculateRecovery(maxLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}

	@Test
	public void testHurtsAlot()// recovers the right amount
	{
		RecoveryBehavior rLinear = new RecoverLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 15;
		int result = rLinear.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(currentLifePts + 3, result);
	}

	@Test
	public void testHurtsALittle()// doesn't recover too much
	{
		RecoveryBehavior rLinear = new RecoverLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 28;
		int result = rLinear.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}

	@Test
	public void testNoRes()// doesn't revive
	{
		RecoveryBehavior rLinear = new RecoverLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 0;
		int result = rLinear.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(currentLifePts, result);
	}

	@Test
	public void testPointless()// goldilox
	{
		RecoveryBehavior rLinear = new RecoverLinear(3);
		int maxLifePts = 30;
		int currentLifePts = 27;
		int result = rLinear.calculateRecovery(currentLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}

}
