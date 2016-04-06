package command;

import environment.Environment;
import exceptions.EnvironmentException;
import lifeform.LifeForm;

public class Move implements Command
{
	LifeForm actor;
	
	public Move(LifeForm lifeForm)
	{
		actor = lifeForm;
	}
	@Override
	public void execute()
	{
		try
		{
			Environment.getWorld().moveLifeForm(actor);
		} catch (EnvironmentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}