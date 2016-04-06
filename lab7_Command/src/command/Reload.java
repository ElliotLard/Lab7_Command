package command;

import environment.Environment;
import lifeform.LifeForm;

public class Reload implements Command
{
	LifeForm actor;
	
	public Reload(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		actor.reload();
	}
	
}
