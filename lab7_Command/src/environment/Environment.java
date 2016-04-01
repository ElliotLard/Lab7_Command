package environment;

import exceptions.EnvironmentException;
import gameplay.SimpleTimer;
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
	public static final int HEIGHT = 50, WIDTH = 50;
	public static final int CELLSIZE = 5;
	private static Environment world;
	private static Cell[][] tileMap;
	private SimpleTimer timer;

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
		timer = new SimpleTimer();
	}
	
	public static Environment getWorld()
	{
		if(world == null)
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

	/**
	 * Fills the specified cell with the given LifeForm
	 * 
	 * @param y
	 * @param x
	 * @param l
	 */
	public void addLifeForm(int y, int x, LifeForm l) throws ArrayIndexOutOfBoundsException
	{
		if(y < 0 || y >= Environment.HEIGHT || x < 0 || x >= Environment.WIDTH)
			throw new ArrayIndexOutOfBoundsException("out of the Environment bounds");
		tileMap[y][x].addLifeForm(l);
	}

	/**
	 * returns the given cell to it's default state.
	 * 
	 * @param y
	 * @param x
	 */
	public void removeLifeForm(int y, int x)
	{
		tileMap[y][x].removeLifeForm();
	}
	
	public static int getDistance(Cell c1, Cell c2)
	{
		int xDistance = CELLSIZE * Math.abs(c1.getxLocation() - c2.getxLocation());
		int yDistance = CELLSIZE * Math.abs(c1.getyLocation() - c2.getyLocation());
		
		int distance = (int)Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2));
		return distance;
		
	}
	
	void moveLifeForm(LifeForm l) throws EnvironmentException
	{
		int y = l.getyLocation(), x = l.getxLocation();
		switch(l.getDirection())
		{
		case NORTH:
			if(y == 0)
				return;
			l.move(y - 1, x);
			break;
		case SOUTH:
			if(y == HEIGHT-1)
				return;
			l.move(y + 1, x);
			break;
		case EAST:
			if(x == WIDTH-1)
				return;
			l.move(y, x + 1);
			break;
		case WEST:
			if(x == 0)
				return;
			l.move(y, x - 1);
			break;
		}
	}
	void update()
	{
		
	}
	

}
