package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Reload implements Command
{
	@Override
	public void executeCommand(int enter)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JButton reload = new JButton("Reload"); 
		reload.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				executeCommand(0);	
			}
		});		
	}

}
