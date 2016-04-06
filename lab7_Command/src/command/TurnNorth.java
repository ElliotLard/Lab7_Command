package command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnNorth implements Command
{
	LifeForm actor;
	
	public TurnNorth(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.turn(Environment.NORTH);
	}
}
