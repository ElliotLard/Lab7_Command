/**
 * 
 * @author elliotlard
 * 
 *         simple recovery type which recovers a set amount of hp.
 */
package recovery;

public class RecoverLinear implements RecoveryBehavior
{

	int amountRecovered;

	/**
	 * @param sets the amount to be recovered when called.
	 */
	public RecoverLinear(int points)
	{
		amountRecovered = points;
	}

	/**
	 * adds the amountRecovered to the current hp and ensures that value is not above max hp.
	 * does not recover any hp if at 0 or max health.
	 */
	public int calculateRecovery(int currentLP, int maxLP)
	{
		if(currentLP == 0)
		{
			return 0;
		}
		else if ((maxLP - currentLP) < amountRecovered)
		{
			return maxLP;
		} else
			return amountRecovered + currentLP;
	}
}
