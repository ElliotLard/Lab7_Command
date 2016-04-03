package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Move implements Command, ActionListener
{
	
	@Override
	public void executeCommand(int enter)
	{
		// Still figuring out where to send the commands
	}

	@Override
	public void actionPerformed(ActionEvent enter) 
	{
		JButton up = new JButton("Up"); 
		up.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				executeCommand(0);	
			}
		});
		JButton down = new JButton("Down"); 
		up.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				executeCommand(2);	
			}
		});
		JButton left = new JButton("Left"); 
		up.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				executeCommand(1);	
			}
		});
		JButton right = new JButton("Right"); 
		up.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				executeCommand(3);	
			}
		});
	}
}