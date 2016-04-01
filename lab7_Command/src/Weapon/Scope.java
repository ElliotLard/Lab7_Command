package Weapon;

public class Scope extends Attachment{
	
	/**
	 * Lab 4 Pistol
	 * @author Christopher Wilson
	 */

	public Scope(GenericWeapon w) {
		super(w);
	}
	
	/**
	 * Calculates the damage done only by the scope and returns as an int.
	 * All values typecast to double so no accidental rounding occurs.
	 * Final result is then typecast as an int.
	 */
	public int calculateDamage(int distance)
	{
		double wpnDmg = (base.range + 10) - distance;
		wpnDmg = 1 + (wpnDmg / (base.range + 10));
		wpnDmg = wpnDmg * base.calculateDamage(distance);
		return (int)wpnDmg;
		//return (int) ((double)(base.calculateDamage(distance) * ((double)(1 +(base.range + 10) - distance)/(base.range + 10))));
	}

}
