package gui;

//Author: Aaron Gerber
//Checks for an input stream, and if there is none it returns a null

public class MyClass
{
	public MyClass()
	{
		
	}
	
	public String inputMethod()
	{
		if(System.in.equals(null))		//Checks if the input is null or not
		{
			return null;
		}
		else
			return "worked";
	}
}
