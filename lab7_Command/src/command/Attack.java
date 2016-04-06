package command;

import lifeform.LifeForm;

public class Attack implements Command
{
	LifeForm actor, victim;
	
	public Attack(LifeForm lifeForm, LifeForm v)
	{
		actor = lifeForm;
		victim = v;
	}
	@Override
	public void execute()
	{
		actor.attack(victim);
	}
}
