package environment;

import java.util.ArrayList;

import Weapon.GenericWeapon;
import lifeform.LifeForm;

/**
 * 
 * @author elliotlard
 *
 */
public class Cell
{
	LifeForm areaMan = null;
	private ArrayList<GenericWeapon> onGround = new ArrayList<GenericWeapon>();
	int xLoc, yLoc;
	
	public Cell(int y, int x)
	{
		xLoc = x;
		yLoc = y;
	}
	public Cell()
	{
		
	}

	/**
	 * returns the LifeForm within the cell
	 * 
	 * @return
	 */
	public LifeForm getLifeForm()
	{
		return areaMan;
	}

	/**
	 * adds the lifeForm to the cell if it is empty and returns true if this is
	 * done succesfully.
	 * 
	 * @param entity
	 * @return
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (areaMan == null)
		{
			areaMan = entity;
			return true;
		} else
			return false;
	}

	public void removeLifeForm()
	{
		areaMan = null;
	}

	public void addWeapon(GenericWeapon w)
	{
		onGround.add(w);
	}
	
	public ArrayList<GenericWeapon> getWeapons()
	{
		return onGround;
	}

	public GenericWeapon getWeapon(int i)
	{
		return onGround.get(i);
	}
	
	public void removeWeapon(GenericWeapon w)
	{
		onGround.remove(w);
	}
	
	public int getxLocation()
	{
		return xLoc;
	}
	
	public int getyLocation()
	{
		return yLoc;
	}
}
