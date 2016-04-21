package gui;

//Author: Aaron Gerber
//Gives the player a set of commands that they can execute

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

import command.*;
import Weapon.ChainGun;
import Weapon.Pistol;
import Weapon.PlasmaCannon;
import environment.Cell;
import environment.Environment;
import gameplay.TimeObserver;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Cursor;

public class Invoker extends JFrame implements TimeObserver
{
	LifeForm player;
	
	
	public Invoker(LifeForm p) 
	{
		//This sets the defaults of the window that the commands will be held in
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		setLocation(new Point(600, 0));
		getContentPane().setMinimumSize(new Dimension(320, 130));
		setSize(new Dimension(320, 130));
		setMaximumSize(new Dimension(320, 130));
		setBounds(new Rectangle(67, 0, 320, 130));
		player = p;
		
		//List of commands that will be used
		//Does not initialize Acquire command as that will change depending on the players cell
		final Command attack = new Attack(player);
		final Command drop = new Drop(player);
		final Command move = new Move(player);
		final Command reload = new Reload(player);
		final Command left = new TurnWest(player);
		final Command right = new TurnEast(player);
		final Command up = new TurnNorth(player);
		final Command down = new TurnSouth(player);
		
		getContentPane().setLayout(null);
		
		
		//Creates and fills a panel full of movement buttons
		//Also sets the minimum size and where it is located
		JPanel Movement = new JPanel();
		Movement.setMinimumSize(new Dimension(120, 75));
		Movement.setLocation(new Point(10, 10));
		Movement.setBounds(10, 10, 120, 75);
		getContentPane().add(Movement);
		Movement.setLayout(null);
		
		//Creates the button that controls the player going up
		JButton btnUp = new JButton("Up");
		btnUp.setBounds(30, 0, 60, 25);
		Movement.add(btnUp);
		//Adds a listener to only the up button, so any other button will not activate it
		btnUp.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Turns the player north and then moves them
		        up.execute();
		        move.execute();
		    }
		});
		
		//Creates the button that controls the player going left
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(0, 25, 60, 25);
		Movement.add(btnLeft);
		
		//Adds a listener to only the left button, so any other button will not activate it
		btnLeft.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Turns the player west and then moves them
		       	left.execute();
		       	move.execute();
		    }
		});
		
		//Creates the button that controls the player going right
		JButton btnRight = new JButton("Right");
		btnRight.setBounds(60, 25, 60, 25);
		Movement.add(btnRight);
		//Adds a listener to only the right button, so any other button will not activate it
		btnRight.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Turns the player east and then moves them
		        right.execute();
		        move.execute();
		    }
		});
		
		//Creates the button that controls the player going down
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(30, 50, 60, 25);
		Movement.add(btnDown);
		//Adds a listener to only the down button, so any other button will not activate it
		btnDown.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Turns the player south and then moves them
		    	down.execute();
		    	move.execute();
		    }
		});
		
		
		//Creates the panel that will hold all of the actions a player can perform and fills it with buttons
		JPanel Actions = new JPanel();
		Actions.setBounds(140, 10, 150, 75);
		getContentPane().add(Actions);
		Actions.setLayout(null);
		
		//Creates the button that controls the players attack
		JButton btnAttack = new JButton("Attack");
		btnAttack.setBounds(10, 5, 70, 23);
		Actions.add(btnAttack);
		btnAttack.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Executes an attack
		    	attack.execute();
		    }
		});
		
		//Creates the button that controls the players reload
		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(80, 5, 70, 23);
		Actions.add(btnReload);
		btnReload.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Executes an reload
		    	attack.execute();
		    }
		});
		
		
		//Creates the button that controls the players acquisition of weapons
		JButton btnPickUp = new JButton("Pick Up");
		btnPickUp.setBounds(10, 33, 70, 23);
		Actions.add(btnPickUp);
		btnPickUp.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Gets the cell of the player and then creates the Acquire command to be used and executes
		    	Cell cell = player.getCell();
		    	Command acquire = new Acquire(player,cell.getWeapon());
		    	acquire.execute();
		    }
		});
		
		//Creates the button that controls the players dropping of weapons
		JButton btnDrop = new JButton("Drop");
		btnDrop.setBounds(80, 33, 70, 23);
		Actions.add(btnDrop);
		btnDrop.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//Executes an reload
		    	drop.execute();
		    }
		});
		
		setVisible(true);
	}

	
	
	@Override
	public void updateTime(int time)
	{
		// TODO Auto-generated method stub
		
	}
}
