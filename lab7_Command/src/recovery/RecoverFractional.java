/**
 * 
 * @author elliotlard
 * 
 *         recovery type for recovering a set portion of missing health.
 */
package recovery;

public class RecoverFractional implements RecoveryBehavior
{
	double fraction;

	/**
	 * constructs the RecoverFractional with the given parameter as a fraction
	 * of 100.
	 * 
	 * @param frac
	 */
	public RecoverFractional(int frac)
	{
		fraction = frac / 100.0;
	}

	/**
	 * returns the new amount of health based on the current and max health.
	 */
	public int calculateRecovery(int currentLP, int maxLP)
	{
		int recoveredHealth = (int) (currentLP * fraction);
		currentLP += recoveredHealth;
		if (currentLP > maxLP)
			return maxLP;
		else
			return currentLP;
	}

}
