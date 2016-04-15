package gui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TestGUI
{

	/**
	 * We can't actually test the GUI directly because there is no way for the
	 * computer to know what it's supposed to look like. Instead we create two
	 * dialogue boxes. You just say yes or no depending on if the display is
	 * working correctly.
	 */
	@Test
	public void testInitialization()
	{
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Create Cell Image Icon Correct For\nHuman(0,0) and Alien(1,1)\nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,
				"Map Legend Displays Correctly\nAlien(Green Triangle)\nDoes it look right?"));
	}
}
