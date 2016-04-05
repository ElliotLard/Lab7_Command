package command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements Command, KeyListener
{
	
	@Override
	public void executeCommand(int keyPressed)
	{
		if (keyPressed == KeyEvent.VK_UP){
			
		}
		if (keyPressed == KeyEvent.VK_DOWN){
			
		}
		if (keyPressed == KeyEvent.VK_LEFT){
			
		}
		if (keyPressed == KeyEvent.VK_RIGHT){
			
		}
	}

	@Override
	public void keyPressed(KeyEvent keyPressed)
	{
		switch (keyPressed.getKeyCode()){
		case KeyEvent.VK_UP:
			executeCommand(KeyEvent.VK_UP);
			break;
		case KeyEvent.VK_DOWN:
			executeCommand(KeyEvent.VK_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			executeCommand(KeyEvent.VK_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			executeCommand(KeyEvent.VK_RIGHT);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
