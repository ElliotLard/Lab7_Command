package command;

import Weapon.GenericWeapon;
import lifeform.LifeForm;

public class Acquire implements Command
{
	LifeForm actor;
	GenericWeapon weapon;
	
	public Acquire(LifeForm lifeForm, GenericWeapon w)
	{
		actor = lifeForm;
		weapon = w;
	}
	@Override
	public void execute()
	{
		actor.pickup(weapon);
	}
}
