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

import Weapon.ChainGun;
import Weapon.Pistol;
import Weapon.PlasmaCannon;
import environment.Cell;
import environment.Environment;
import lifeform.Alien;
import lifeform.Human;

public class GUI extends JFrame implements ActionListener
{	
	int what[] = {0, 10, 20};
	int huh[] = {20, 0, 20};
	int derp = 3;
	
	
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
		 * Makes the map key for the left panel of the frame.
		 * Going to keep it this way for now because it works,
		 * but probably should see if there's a way to shrink it.
		 */
		JPanel mapKey = new JPanel (new GridLayout(5, 1));
		JLabel[][] keyArray = new JLabel[5][1];
		
		keyArray[0][0] = new JLabel (createTriangle());
		mapKey.add(keyArray[0][0]);
		keyArray[0][0] = new JLabel (" - Alien");
		mapKey.add(keyArray[0][0]);
		
		keyArray[1][0] = new JLabel (createCircle());
		mapKey.add(keyArray[1][0]);
		keyArray[1][0] = new JLabel (" - Human");
		mapKey.add(keyArray[1][0]);
		
		keyArray[2][0] = new JLabel (createPistol());
		mapKey.add(keyArray[2][0]);
		keyArray[2][0] = new JLabel (" - Pistol");
		mapKey.add(keyArray[2][0]);
		
		keyArray[3][0] = new JLabel (createChainGun());
		mapKey.add(keyArray[3][0]);
		keyArray[3][0] = new JLabel (" - ChainGun");
		mapKey.add(keyArray[3][0]);
		
		keyArray[4][0] = new JLabel (createPlasmaCannon());
		mapKey.add(keyArray[4][0]);
		keyArray[4][0] = new JLabel (" - PlasmaCannon ");
		mapKey.add(keyArray[4][0]);
		
		add("East", mapKey);
		
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
					labelArray[x][y] = new JLabel (createTriangle());
				}
				/**
				 * Checks for a Human and places an H if it finds one.
				 */
				else if (Environment.getWorld().getLifeForm(x, y) instanceof Human)
				{
					labelArray[x][y] = new JLabel (createCircle());
				}
				/**
				 * If nothing is found it places a dot. Spacing is to keep
				 * the window more uniform till I figure out cell padding.
				 */
				
				else if (Environment.getWorld().getWeapon(x, y) instanceof Pistol)
				{
					labelArray[x][y] = new JLabel (createPistol());
				}
				else if (Environment.getWorld().getWeapon(x, y) instanceof ChainGun)
				{
					labelArray[x][y] = new JLabel (createChainGun());
				}
				else if (Environment.getWorld().getWeapon(x, y) instanceof PlasmaCannon)
				{
					labelArray[x][y] = new JLabel (createPlasmaCannon());
				}
				else
				{
					labelArray[x][y] = new JLabel (createGround());
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
	
	public ImageIcon createTriangle(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(0, 255, 0));
		drawer.fillPolygon(what, huh,  derp);
		
		return new ImageIcon(Image);
	}
	
	public ImageIcon createCircle(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(255, 0, 0));
		drawer.fillOval(0,  0,  20,  20);
		
		return new ImageIcon(Image);
	}
	
	public ImageIcon createGround(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0,  0,  20,  20);
		
		drawer.setColor(new Color(0, 0, 0));
		drawer.drawRect(0, 0, 20, 20);
		
		return new ImageIcon(Image);
	}
	
	public ImageIcon createPistol(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(255, 255, 0));
		drawer.fillOval(5,  5,  10,  10);
		
		return new ImageIcon(Image);
	}
	
	public ImageIcon createChainGun(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(0, 255, 255));
		drawer.fillOval(5,  5,  10,  10);
		
		return new ImageIcon(Image);
	}
	
	public ImageIcon createPlasmaCannon(){
		BufferedImage Image = new
				BufferedImage (20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();
		
		drawer.setColor(new Color(255, 0, 255));
		drawer.fillOval(5,  5,  10,  10);
		
		return new ImageIcon(Image);
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