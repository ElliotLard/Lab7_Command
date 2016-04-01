package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryNone
{
	/**
	 * LAB2 TESTS
	 */
	@Test
	public void testRecoverNone()
	{
		RecoveryBehavior rNone = new RecoverNone();
		assertEquals(rNone.calculateRecovery(5, 10), 5);// when at less than
														// full health
		assertEquals(rNone.calculateRecovery(10, 10), 10);// when at full health
	}

}
