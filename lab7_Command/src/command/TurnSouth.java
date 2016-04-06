package command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnSouth implements Command
{
	LifeForm actor;
	
	public TurnSouth(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.turn(Environment.SOUTH);
	}
}
