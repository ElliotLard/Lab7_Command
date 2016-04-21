package gui;

import lifeform.*;
import environment.*;


public class InvokerBuilder
{
	static LifeForm player = null;
	
	public InvokerBuilder(LifeForm p)
	{
		player = p;
	}
	
	public static void main(String argc[])
	{
		
		
		
		Invoker window = new Invoker(player);
	}

}
