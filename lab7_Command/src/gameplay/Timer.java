/**
 * @author elliotlard
 * Interface Timer
 * Timer is an interface
 */

package gameplay;

public interface Timer
{
	void addTimeObserver(TimeObserver observer);

	void removeTimeObserver(TimeObserver observer);

	void timeChanged();
}
