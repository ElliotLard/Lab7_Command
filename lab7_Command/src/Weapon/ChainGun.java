/**
 * @author elliotlard
 *         Concrete version of GenericWeapon which modifies the constructor and calculateDamage() method
 */
package Weapon;

public class ChainGun extends GenericWeapon
{
	private static final int BASEDAMAGE = 15, RANGE = 30, RATEOFFIRE = 4, MAXAMMO = 40;

	public ChainGun()
	{
		super(BASEDAMAGE, RANGE, RATEOFFIRE, MAXAMMO);
	}

	/**
	 * calculates the damage to be returned based on the distance from the
	 * target. damage is equal to the base damage multiplied by the (distance
	 * over the range)
	 * 
	 * @param distance
	 * @return damage
	 */
	public int calculateDamage(int distance)
	{
		int damage;
		if (distance > this.getRange())
			return 0;
		damage = (int) ((double) baseDamage * ((double) distance / (double) this.getRange()));
		return damage;
	}
}
