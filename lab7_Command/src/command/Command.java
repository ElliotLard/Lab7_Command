package command;

import java.awt.event.ActionListener;

public interface Command extends ActionListener
{
	public void executeCommand(int enter);
}
