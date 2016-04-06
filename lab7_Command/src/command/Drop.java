package command;

import lifeform.LifeForm;

public class Drop implements Command
{
	LifeForm actor;
	
	public Drop(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.dropGun();
	}
}
