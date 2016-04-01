package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoverFractional
{
	/**
	 * LAB2 TESTS
	 */
	@Test
	public void testRecover()
	{
		RecoveryBehavior rb = new RecoverFractional(50);
		assertEquals(60, rb.calculateRecovery(40, 100));// for a normal amount
		assertEquals(100, rb.calculateRecovery(100, 100));// when already at
															// maxLP
		assertEquals(100, rb.calculateRecovery(95, 100));// can't go over maxLP
		assertEquals(0, rb.calculateRecovery(0, 100));// can't come back from
														// dead

	}

}
