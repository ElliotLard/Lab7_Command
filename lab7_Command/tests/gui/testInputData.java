package gui;

import static org.junit.Assert.*;

import java.io.*;

import javax.swing.JOptionPane;

import org.junit.Test;

//Author: Aaron Gerber
//Tests that the MyClass is properly working and able to detect an input stream
//testInputData() code comes from lab manual 


public class testInputData
{
	@Test
	public void testInputData()
	{
		MyClass testClass = new MyClass();
	
		String testData = "3/nyes/n";
	
		byte[] byteData = testData.getBytes();
	
		ByteArrayInputStream testInput = new ByteArrayInputStream(byteData);
	
		System.setIn(testInput);
	
		String output = testClass.inputMethod();
		assertEquals("worked",output);
	}
}
