package command;

import lifeform.LifeForm;

public class Attack implements Command
{
	LifeForm actor;
	
	public Attack(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.attack(actor, actor.getDirection());
	}
}
