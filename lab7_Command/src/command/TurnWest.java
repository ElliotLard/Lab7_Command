package command;

import environment.Environment;
import lifeform.LifeForm;

public class TurnWest implements Command
{
	LifeForm actor;
	
	public TurnWest(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.turn(Environment.WEST);
	}
}
