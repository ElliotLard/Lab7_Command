/**
 * @author elliotlard
 *         Concrete version of Attachment which modifies the shoot() and calculateDamage() method
 */
package Weapon;

public class Stabilizer extends Attachment
{

	/**
	 * @param baseWeapon
	 */
	public Stabilizer(GenericWeapon w)
	{
		super(w);
	}

	/**
	 * increases the damage of the base weapon by 25%
	 * 
	 * @return damage
	 * @param distance
	 */
	public int calculateDamage(int distance)
	{ // increases damage by 25%
		// rounding down
		return base.calculateDamage(distance) + (int) ((double) base.calculateDamage(distance) * .25);
	}

	/**
	 * @return damage
	 * @param distance
	 *            reloads the gun if it will be empty after firing that shot
	 */
	public int shoot(int distance) // reloads the gun if it will be empty after
									// firing
	// that shot
	{
		if (ammo == 1)
		{
			reload();
			ammo++; // since the reloading should actually be happening after
					// the shot
		}

		return super.shoot(distance);

	}

}
