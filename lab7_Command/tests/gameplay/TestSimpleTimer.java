package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

class MockSimpleTimeObserver implements TimeObserver
{
	public int myTime = 0;

	public void updateTime(int time)
	{
		myTime = time;
	}
}

public class TestSimpleTimer
{

	/**
	 * LAB3 TESTS
	 */

	@Test
	public void testConstruction()
	{
		MockSimpleTimeObserver m = new MockSimpleTimeObserver();
		SimpleTimer t = new SimpleTimer();
		assertEquals(0, t.round);// initializes correctly
		t.addTimeObserver(m);
		assertEquals(m, t.getTimeObserver(0));// m is the observer at location 0
		t.timeChanged();
		assertEquals(1, t.round);// works with an observer
		t.removeTimeObserver(m);
		assertEquals(0, t.getObserverSize());// the size is 0 if there are no
												// observers
		t.timeChanged();
		assertEquals(2, t.round);// works without an observer

	}

	@Test
	public void testSimpleTimerAsThread() throws InterruptedException
	{
		SimpleTimer st = new SimpleTimer(1000);
		st.start();
		Thread.sleep(250);// 1/4 of a second different
		for (int x = 0; x < 5; x++)
		{
			assertEquals(x, st.round);// assumes round starts at 0
			Thread.sleep(1000);// wait for the next time change
		}
	}

}
