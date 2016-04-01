package Weapon;

public class Pistol extends GenericWeapon
{
	
	/**
	 * Sets the generic values of Pistol so we don't have to
	 * enter in values every time we create an instance of Pistol.
	 */
	private static final int BASEDAMAGE=10, RANGE=25, RATEOFFIRE=2, MAXAMMO=10;
	public Pistol()
	{
		super(BASEDAMAGE, RANGE, RATEOFFIRE, MAXAMMO);
	}
	
	/**
	 * Calculates the damage for Pistol, taking an instance variable
	 * "distance" representing how far the weapon is from its target.
	 */
	public int calculateDamage(int distance)
	{
		int damage; // Value to be returned for damage

		if (distance > RANGE) // If the range is too far, do no damage
		{
			damage = 0;
			return damage;
		}
		/**
		 * Uses two temp variables to hold values as doubles. This prevents
		 * the program from rounding down to zero at any point and causing
		 * zero damage by mistake.
		 * Values are then multiplied together and typecast to an int
		 * which is then returned.
		 */
		else
		{
			double tempCalc = (RANGE - distance + 5);
			double tempCalcNext = tempCalc/RANGE;
			damage = (int) (baseDamage * tempCalcNext);
			return damage;
		}
	}
}
