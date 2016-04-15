package environment;

import Weapon.GenericWeapon;
import exceptions.EnvironmentException;
import lifeform.LifeForm;

/**
 * 
 * @author elliotlard
 *
 *         A class for managing the gamespace
 */
public class Environment
{
	public static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
	public static final int HEIGHT = 10, WIDTH = 10;
	public static final int CELLSIZE = 5;
	private static Environment world;
	private Cell[][] tileMap;

	/**
	 * Constructs the environment class creating the tileMap 2d array and
	 * filling it with empty cells.
	 * 
	 * @param height
	 * @param width
	 */
	private Environment(int height, int width)
	{
		tileMap = new Cell[height][width];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tileMap[y][x] = new Cell(y, x);
			}
		}
	}

	public static Environment getWorld()
	{
		if (world == null)
			world = new Environment(Environment.HEIGHT, Environment.WIDTH);
		return world;
	}

	public Cell getCell(int y, int x)
	{
		return tileMap[y][x];
	}

	/**
	 * returns the lifeForm at the specified location.
	 * 
	 * @param y
	 * @param x
	 * @return
	 */
	public LifeForm getLifeForm(int y, int x)
	{
		return tileMap[y][x].getLifeForm();
	}
	
	public GenericWeapon getWeapon(int y, int x)
	{
		return tileMap[y][x].getWeapon();
	}

	/**
	 * Fills the specified cell with the given LifeForm
	 * 
	 * @param y
	 * @param x
	 * @param l
	 */
	public void addLifeForm(int y, int x, LifeForm l) throws ArrayIndexOutOfBoundsException
	{
		if (y < 0 || y >= Environment.HEIGHT || x < 0 || x >= Environment.WIDTH)
			throw new ArrayIndexOutOfBoundsException("out of the Environment bounds");
		l.move(this.getCell(y, x));
	}

	/**
	 * returns the given cell to it's default state.
	 * 
	 * @param y
	 * @param x
	 * 
	 */
	public void removeLifeForm(int y, int x)
	{
		tileMap[y][x].removeLifeForm();
	}

	/**
	 * @author elliotlard
	 * 
	 *         finds the distance between 2 cells
	 * 
	 * @param cell1, cell2
	 * @return int the distance between the cells
	 */
	public static int getDistance(Cell cell1, Cell cell2)
	{
		int xDistance = CELLSIZE * Math.abs(cell1.getxLocation() - cell2.getxLocation());
		int yDistance = CELLSIZE * Math.abs(cell1.getyLocation() - cell2.getyLocation());

		int distance = (int) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		return distance;

	}

	/**
	 * @author elliotlard
	 * 
	 *         this method will move a lifeForm by first setting the number of
	 *         actionPoints equal to the maxSpeed It will then attempt to move
	 *         actionPoints spaces in the currentDirection if that spot is
	 *         occupied or offscreen it will decrease actionPoints by 1 and then
	 *         repeat until actionPoints is 0 or the movement is succesfull.
	 * 
	 * @param lifeForm
	 *            the lifeForm you wish to move
	 * @throws EnvironmentException
	 */
	public void moveLifeForm(LifeForm lifeForm) throws EnvironmentException
	{
		int actionPoints = lifeForm.getMaxSpeed();
		
		//y and x coordinates of the lifeForm for readablity
		int y = lifeForm.getyLocation(), x = lifeForm.getxLocation();
		
		
		//switch case determines the direction and attempts to move accordingly
		switch (lifeForm.getDirection())
		{
		case NORTH:
			while (actionPoints > 0)
			{
				if (actionPoints == 0 || y == 0) //termination conditions
					return;
				//if location is onscreen and unoccupied
				if ((y - actionPoints) >= 0 && tileMap[y - actionPoints][x].getLifeForm() == null)
				{
					lifeForm.move(y - actionPoints, x);
					actionPoints = 0;
				} else //decrement actionPoints and restart loop
					actionPoints--;
			}
			break;
		case SOUTH:
			while (actionPoints > 0)
			{
				if (actionPoints == 0 || y == HEIGHT)
					return;
				if ((y + actionPoints) < HEIGHT && tileMap[y + actionPoints][x].getLifeForm() == null)
				{
					lifeForm.move(y + actionPoints, x);
					actionPoints = 0;
				} else
					actionPoints--;
			}
			break;
		case EAST:
			while (actionPoints > 0)
			{
				if (actionPoints == 0 || x == WIDTH)
					return;
				if ((x + actionPoints) < WIDTH && tileMap[y][x + actionPoints].getLifeForm() == null)
				{
					lifeForm.move(y, x + actionPoints);
					actionPoints = 0;
				} else
					actionPoints--;
			}
			break;
		case WEST:
			while (actionPoints > 0)
			{
				if (actionPoints == 0 || x == 0)
					return;
				if ((x - actionPoints) >= 0 && tileMap[y][x - actionPoints].getLifeForm() == null)
				{
					lifeForm.move(y, x - actionPoints);
					actionPoints = 0;
				} else
				{
					actionPoints--;
				}
			}
			break;
		}

	}
}
