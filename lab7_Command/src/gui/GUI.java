package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Cell;
import environment.Environment;
import lifeform.Alien;
import lifeform.Human;

public class GUI extends JFrame implements ActionListener
{
	/**
	 * Just leave these be for now. Won't need them by turn in but it's
	 * going to be mad if they're removed without also removing them elsewhere
	 */
	JButton textButton, imageButton;
	JLabel textLabel, imageLabel;	
	
	public GUI(){
		
		/**
		 * Sets a BorderLayout in JFrame. This means we have a
		 * North, South, East, West, and Center panel we can
		 * use to hold JPanels, which can hold their own individual
		 * layouts.
		 * 
		 * If a panel in BorderLayout is not used, the space is taken
		 * over by the other panels that are used. By only declaring
		 * a JPanel in the center and east frames, I get the
		 * appropriate layout for the map.
		 */
		setLayout (new BorderLayout());
		
		/**
		 * Just a spot filler for now. Will be replaced with a map legend.
		 */
		textButton = new JButton("A Button");
		add("East", textButton);
		
		/**
		 * This section defines the center frame. To stay consistent I'm using
		 * the constants from the environment class to define the grid size.
		 */
		
		/**
		 * This first line creates a JPanel called centerPanel. Since it's a grid I have
		 * to define the height and width. This is done with labelArray, which is what
		 * will actually be displayed.
		 * 
		 * The for loop checks through the world map for instances of objects and
		 * labels them according on the labelArray.
		 */
		JPanel centerPanel = new JPanel (new GridLayout(Environment.HEIGHT,Environment.WIDTH));
		JLabel[][] labelArray = new JLabel[Environment.HEIGHT][Environment.WIDTH];
		for (int x = 0; x < Environment.HEIGHT; x++){
			for (int y = 0; y < Environment.WIDTH; y++){
				/**
				 * Checks for an Alien and places an A if it finds one.
				 */
				if (Environment.getWorld().getLifeForm(x, y) instanceof Alien)
				{
					labelArray[x][y] = new JLabel ("  A  ");
				}
				/**
				 * Checks for a Human and places an H if it finds one.
				 */
				else if (Environment.getWorld().getLifeForm(x, y) instanceof Human)
				{
					labelArray[x][y] = new JLabel ("  H  ");
				}
				/**
				 * If nothing is found it places a dot. Spacing is to keep
				 * the window more uniform till I figure out cell padding.
				 */
				else
				{
					labelArray[x][y] = new JLabel ("  .  ");
				}
				
				/**
				 * Sets centerPanel to hold the labelArray after it is created.
				 */
				centerPanel.add(labelArray[x][y]);
			}
		}
		
		/**
		 * puts centerPanel in to the center area of our game board
		 */
		add("Center", centerPanel);
		
		/**
		 * This builds the JFrame and makes it visible.
		 */
		pack();
		setVisible(true);
	}

	/**
	 * Not touched yet
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// Seriously. I haven't done this.
		
		// Stahp
	}
}