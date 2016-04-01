/**
 * 
 * @author elliotlard
 * 
 *         the default recovery type that does not recover any hp.
 */
package recovery;

public class RecoverNone implements RecoveryBehavior {

	public RecoverNone()
	{
	}

	public int calculateRecovery(int currentLP, int maxLP)
	{
		return currentLP;
	}

}
