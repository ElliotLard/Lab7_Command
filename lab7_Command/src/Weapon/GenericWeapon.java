/**
 * @author elliotlard
 *         Abstact class holding the generic functionality of the guns
 */
package Weapon;

import gameplay.TimeObserver;

public abstract class GenericWeapon implements TimeObserver
{
	int baseDamage, range, rateOfFire, ammo, maxAmmo, shotsRemaining;

	public GenericWeapon(int d, int r, int rof, int a)
	{
		baseDamage = d;
		range = r;
		rateOfFire = rof;
		ammo = a;
		maxAmmo = a;
	}

	public int calculateDamage(int d)
	{
		return baseDamage;
	}

	/**
	 * fires the weapon if it has ammo or returns 0 if it does not. subtracts 1
	 * ammo and then returns the damage based on the calculateDamage(int)
	 * method.
	 * 
	 * @param distance
	 * @return damage
	 */
	public int shoot(int distance)
	{
		if (ammo > 0)
		{
			ammo--;
			shotsRemaining--;
			if (range >= distance)
			{
				return calculateDamage(distance);
			}
		}
		return 0;
	}

	/**
	 * returns the gun to maxAmmo
	 */
	public void reload()
	{
		ammo = maxAmmo;
	}

	/**
	 * shows that a turn has passed and the gun returns to it's max shots
	 * remaining
	 * 
	 * @param time
	 */
	public void updateTime(int time)
	{
		shotsRemaining = rateOfFire;
	}

	/**
	 * @return baseDamage
	 */
	public int getBaseDamage()
	{
		return baseDamage;
	}

	/**
	 * @return range
	 */
	public int getRange()
	{
		return range;
	}

	/**
	 * @return rateOfFire
	 */
	public int getRateOfFire()
	{
		return rateOfFire;
	}

	/**
	 * @return ammo
	 */
	public int getAmmo()
	{
		return ammo;
	}

	/**
	 * @return maxAmmo
	 */
	public int getMaxAmmo()
	{
		return maxAmmo;
	}

}
