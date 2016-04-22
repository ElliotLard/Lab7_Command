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
import gameplay.TimeObserver;
import lifeform.Alien;
import lifeform.Human;

public class GUI extends JFrame implements TimeObserver
{
	/**
	 * Coordinates used to generate vertex coordinates to create custom shapes.
	 */
	int xCord[] = { 0, 10, 20 };
	int yCord[] = { 20, 0, 20 };
	int connects = 3;
	
	JPanel mapKey = new JPanel(new GridLayout(5, 1));
	JLabel[][] keyArray = new JLabel[5][1];
	
	JPanel centerPanel = new JPanel(new GridLayout(Environment.HEIGHT, Environment.WIDTH));
	JLabel[][] labelArray = new JLabel[Environment.HEIGHT][Environment.WIDTH];
	
	int time;

	public GUI()
	{
		/**
		 * Sets a BorderLayout in JFrame. This means we have a North, South,
		 * East, West, and Center panel we can use to hold JPanels, which can
		 * hold their own individual layouts.
		 * 
		 * If a panel in BorderLayout is not used, the space is taken over by
		 * the other panels that are used. By only declaring a JPanel in the
		 * center and east frames, I get the appropriate layout for the map.
		 */
		setLayout(new BorderLayout());

		/**
		 * Makes the map key for the left panel of the frame. Going to keep it
		 * this way for now because it works, but probably should see if there's
		 * a way to shrink it.
		 */

		keyArray[0][0] = new JLabel(createTriangle());
		mapKey.add(keyArray[0][0]);
		keyArray[0][0] = new JLabel(" - Alien");
		mapKey.add(keyArray[0][0]);

		keyArray[1][0] = new JLabel(createCircle());
		mapKey.add(keyArray[1][0]);
		keyArray[1][0] = new JLabel(" - Human");
		mapKey.add(keyArray[1][0]);

		keyArray[2][0] = new JLabel(createPistol());
		mapKey.add(keyArray[2][0]);
		keyArray[2][0] = new JLabel(" - Pistol");
		mapKey.add(keyArray[2][0]);

		keyArray[3][0] = new JLabel(createChainGun());
		mapKey.add(keyArray[3][0]);
		keyArray[3][0] = new JLabel(" - ChainGun");
		mapKey.add(keyArray[3][0]);

		keyArray[4][0] = new JLabel(createPlasmaCannon());
		mapKey.add(keyArray[4][0]);
		keyArray[4][0] = new JLabel(" - PlasmaCannon ");
		mapKey.add(keyArray[4][0]);

		add("East", mapKey);

		/**
		 * This section defines the center frame. To stay consistent I'm using
		 * the constants from the environment class to define the grid size.
		 */

		/**
		 * This first line creates a JPanel called centerPanel. Since it's a
		 * grid I have to define the height and width. This is done with
		 * labelArray, which is what will actually be displayed.
		 * 
		 * The for loop checks through the world map for instances of objects
		 * and labels them according on the labelArray.
		 */
		for (int x = 0; x < Environment.HEIGHT; x++) {
			for (int y = 0; y < Environment.WIDTH; y++) {
				/**
				 * Checks for an Alien and places a green triangle if it finds
				 * one.
				 */
				if (Environment.getWorld().getLifeForm(x, y) instanceof Alien) {
					labelArray[x][y] = new JLabel(createTriangle());
				}
				/**
				 * Checks for a Human and places an red circle if it finds one.
				 */
				else if (Environment.getWorld().getLifeForm(x, y) instanceof Human) {
					labelArray[x][y] = new JLabel(createCircle());
				}
				/**
				 * If nothing is found it places a dot. Spacing is to keep the
				 * window more uniform till I figure out cell padding.
				 */

				else if (Environment.getWorld().getWeapon(x, y) instanceof Pistol) {
					labelArray[x][y] = new JLabel(createPistol());
				} else if (Environment.getWorld().getWeapon(x, y) instanceof ChainGun) {
					labelArray[x][y] = new JLabel(createChainGun());
				} else if (Environment.getWorld().getWeapon(x, y) instanceof PlasmaCannon) {
					labelArray[x][y] = new JLabel(createPlasmaCannon());
				} else {
					labelArray[x][y] = new JLabel(createGround());
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
	 * Green triangle used to represent Aliens
	 * 
	 * @return
	 */
	public ImageIcon createTriangle()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(0, 255, 0));
		drawer.fillPolygon(xCord, yCord, connects);

		return new ImageIcon(Image);
	}

	/**
	 * Red Circle used to represent humans
	 * 
	 * @return
	 */
	public ImageIcon createCircle()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(255, 0, 0));
		drawer.fillOval(0, 0, 20, 20);

		return new ImageIcon(Image);
	}

	/**
	 * Ground is represented by a gray square with a black border.
	 * 
	 * @return
	 */
	public ImageIcon createGround()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0, 0, 20, 20);

		drawer.setColor(new Color(0, 0, 0));
		drawer.drawRect(0, 0, 20, 20);

		return new ImageIcon(Image);
	}

	/**
	 * Makes a tiny purple dot for a pistol
	 * 
	 * @return
	 */
	public ImageIcon createPistol()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(255, 255, 0));
		drawer.fillOval(5, 5, 10, 10);

		return new ImageIcon(Image);
	}

	/**
	 * Makes a tiny teal dot for a Chain Gun
	 * 
	 * @return
	 */
	public ImageIcon createChainGun()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(0, 255, 255));
		drawer.fillOval(5, 5, 10, 10);

		return new ImageIcon(Image);
	}

	/**
	 * Makes a tiny purple dot for Plasma Cannon
	 * 
	 * @return
	 */
	public ImageIcon createPlasmaCannon()
	{
		BufferedImage Image = new BufferedImage(20, 20, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics drawer = Image.getGraphics();

		drawer.setColor(new Color(255, 0, 255));
		drawer.fillOval(5, 5, 10, 10);

		return new ImageIcon(Image);
	}

	/**
	 * Every five seconds the GUI is redrawn and updated. Must be added as a
	 * TimeObserver to function.
	 */

	@Override
	public void updateTime(int time)
	{
		if (time % 2 == 0) {
			revalidate();
			repaint();
		}
//		this.time = time;
	}
	
	public void repaint()
	{
		/**
		 * This section defines the center frame. To stay consistent I'm using
		 * the constants from the environment class to define the grid size.
		 */

		/**
		 * This first line creates a JPanel called centerPanel. Since it's a
		 * grid I have to define the height and width. This is done with
		 * labelArray, which is what will actually be displayed.
		 * 
		 * The for loop checks through the world map for instances of objects
		 * and labels them according on the labelArray.
		 */
		for (int x = 0; x < Environment.HEIGHT; x++) {
			for (int y = 0; y < Environment.WIDTH; y++) {
				/**
				 * Checks for an Alien and places a green triangle if it finds
				 * one.
				 */
				if (Environment.getWorld().getLifeForm(x, y) instanceof Alien) {
					labelArray[x][y].setIcon(createTriangle());
				}
				/**
				 * Checks for a Human and places an red circle if it finds one.
				 */
				else if (Environment.getWorld().getLifeForm(x, y) instanceof Human) {
					labelArray[x][y].setIcon(createCircle());
				}


				else if (Environment.getWorld().getWeapon(x, y) instanceof Pistol) {
					labelArray[x][y].setIcon(createPistol());
				} else if (Environment.getWorld().getWeapon(x, y) instanceof ChainGun) {
					labelArray[x][y].setIcon(createChainGun());
				} else if (Environment.getWorld().getWeapon(x, y) instanceof PlasmaCannon) {
					labelArray[x][y].setIcon(createPlasmaCannon());
				} else {
					labelArray[x][y].setIcon(createGround());
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
}