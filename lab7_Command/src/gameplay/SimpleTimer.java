/**
 * @author elliotlard
 * Class SimpleTimer
 * holds the current round of the game.
 * delay is the amount of time it sleeps
 * MAXROUND is the max length of the game
 * Holds the Arraylist theObservers which are everything that gets updated when timechanged is called
 **/
package gameplay;

import java.util.ArrayList;

public class SimpleTimer extends Thread implements Timer
{
	int round = 0;
	int delay;
	final int MAXROUND = 50;
	private ArrayList<TimeObserver> theObservers = new ArrayList<TimeObserver>();

	public SimpleTimer(int d)
	{
		delay = d;
	}

	public SimpleTimer()
	{
		this(1000);
	}

	/**
	 * adds a TimeObserver to the ArrayList
	 */
	public void addTimeObserver(TimeObserver observer)
	{
		theObservers.add(observer);
	}

	/**
	 * removes a TimeObserver from the ArrayList
	 */
	public void removeTimeObserver(TimeObserver observer)
	{
		theObservers.remove(observer);
	}

	/**
	 * updates all of the observers and iterates the round.
	 */
	public void timeChanged()
	{
		round++;
		for (int x = 0; x < theObservers.size(); x++)
		{
			theObservers.get(x).updateTime(round);
		}
	}

	/**
	 * gets the observer at the given index
	 * 
	 * @param i
	 * @return
	 */
	public TimeObserver getTimeObserver(int i)
	{
		return theObservers.get(i);
	}

	/**
	 * 
	 * @return the number of observers
	 */
	public int getObserverSize()
	{
		return theObservers.size();
	}

	/**
	 * what happens when the thread method "run()" is called.
	 */
	public void run()
	{
		for (int x = 0; x < MAXROUND; x++)
		{
			try
			{
				sleep(delay);
				this.timeChanged();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
