/**
 * @author elliotlard
 * Class Alien
 * Alien is a subclass of life form which adds the functionality of being able to recover.
 */
package lifeform;

import environment.Environment;
import exceptions.ExceptionNegative;
import recovery.RecoverNone;
import recovery.RecoveryBehavior;

public class Alien extends LifeForm
{
	int recoverRate;
	RecoveryBehavior myRecovery;

	/**
	 * an alien is constructed with a RecoveryBehavior as well as everything in
	 * LifeForm constructor.
	 */
	public Alien(String name, int points, RecoveryBehavior rb, int ad, int rr) throws ExceptionNegative
	{
		super(name, points, ad);
		if (rr < 0)
			throw new ExceptionNegative();	
		myRecovery = rb;
		recoverRate = rr;
		maxSpeed = 2;
	}

	public Alien(String name, int points, RecoveryBehavior rb, int ad) throws ExceptionNegative
	{
		this(name, points, rb, ad, 2);
	}

	public Alien(String name, int points, RecoveryBehavior rb) throws ExceptionNegative
	{
		this(name, points, rb, 10);
	}

	public Alien(String name, int points) throws ExceptionNegative
	{
		this(name, points, new RecoverNone());
	}

	public Alien(int points) throws ExceptionNegative
	{
		this("default", points);
	}

	public Alien() throws ExceptionNegative
	{
		this(20);
	}

	/**
	 * recovers using the appropriate behavior using the current and max life
	 * points as parameters
	 */
	public void recover()
	{
		currentLP = myRecovery.calculateRecovery(currentLP, maxLP);
	}

	/**
	 * @param the
	 *            lifepoints you wish to set it to.
	 */
	public void setCurrentLifePoints(int points)
	{
		currentLP = points;
	}

	public void setRecoverRate(int rate)
	{
		recoverRate = rate;
	}

	public int getRecoverRate()
	{
		return recoverRate;
	}

	@Override
	public void updateTime(int time)
	{
		if (recoverRate != 0)
			if (time % recoverRate == 0)
				this.recover();
	}

}
