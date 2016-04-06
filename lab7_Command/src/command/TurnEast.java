package command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnEast implements Command
{
	LifeForm actor;
	
	public TurnEast(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.turn(Environment.EAST);
	}
}
