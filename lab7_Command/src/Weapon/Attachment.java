/**
 * @author elliotlard
 *         Abstact class for decorations to GenericWeapon
 */
package Weapon;

public abstract class Attachment extends GenericWeapon
{
	GenericWeapon base;

	public Attachment(GenericWeapon w)
	{
		super(w.getBaseDamage(), w.getRange(), w.getRateOfFire(), w.getMaxAmmo());
		base = w;
	}

}
