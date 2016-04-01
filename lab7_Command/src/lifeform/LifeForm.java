package lifeform;

import Weapon.GenericWeapon;
import environment.Cell;
import environment.Environment;
import exceptions.EnvironmentException;
import gameplay.TimeObserver;

/**
 * 
 * @author elliotlard
 * 
 *         Holds the name and current health of a lifeForm
 */
public abstract class LifeForm implements TimeObserver
{
	String myName;
	int currentLP, maxLP, attackStrength, currentDirection, speed, maxSpeed;
	GenericWeapon weapon;
	Cell location;

	/**
	 * constructs a LifeForm with a given name and health.
	 * 
	 * @param name
	 * @param points
	 */
	public LifeForm(String name, int points, int ad)
	{
		myName = name;
		maxLP = points;
		currentLP = maxLP;
		attackStrength = ad;
		speed = maxSpeed;
		currentDirection = Environment.NORTH;
	}

	/**
	 * returns the name of the LifeForm.
	 * 
	 * @return
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getLifePoints()
	{
		return currentLP;
	}

	/**
	 * returns the maxlifePoints of the LifeForm
	 * 
	 * @return
	 */
	public int getMaxLifePoints()
	{
		return maxLP;
	}

	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getAttackStrength()
	{
		return attackStrength;
	}

	/**
	 * Attempts to attack another LifeForm, first by using the equipped weapon
	 * which expends ammo, or by using it's basic attack if out of ammo and in
	 * range.
	 * 
	 * @param victim
	 *            the LifeForm to be attacked
	 * @param distance
	 *            the distance to be passed into calculate distance
	 */
	public void attack(LifeForm victim)
	{
		if (currentLP == 0)
			return;
		int distance = Environment.getDistance(this.getCell(), victim.getCell());
		if (!(weapon==null) && weapon.getAmmo() > 0)
		{
			victim.takeHit((weapon.shoot(distance)));
		} else
			autoAttack(victim);
	}
	
	public void autoAttack(LifeForm victim)
	{
		if(Environment.getDistance(this.getCell(), victim.getCell()) <= 5)
		victim.takeHit(attackStrength);
	}
	
	/**
	 * removes "damage" from the current life points.
	 * 
	 * @param damage
	 */
	public void takeHit(int damage)
	{
		currentLP -= damage;
		if (currentLP < 0)
		{
			currentLP = 0;
		}
	}

	/**
	 * makes gun the equipped weapon if none is equipped
	 * 
	 * @param gun
	 *            weapon to be equipped
	 */
	public void pickup(GenericWeapon gun)
	{
		if (weapon == null)
			weapon = gun;
	}

	/**
	 * returns the current weapon equipped;
	 * 
	 * @return weapon
	 */
	public GenericWeapon getWeapon()
	{
		return weapon;
	}

	/**
	 * drops the current weapon, making the value null;
	 */
	public void dropGun()
	{
		weapon = null;
	}

	/**
	 * calls the weapons reload() method.
	 */
	public void reload()
	{
		weapon.reload();
	}
	
	/**
	 * moves the LifeForm to this cell
	 */
	public void move(Cell c)
	{
		location = c;
		c.addLifeForm(this);
	}
	
	
	/**
	 * moves the LifeForm to the cell location
	 */
	public void move(int y, int x) throws EnvironmentException
	{
		if(y < 0 || y >= Environment.HEIGHT || x < 0 || x > Environment.WIDTH)
			throw new EnvironmentException();
		this.move(Environment.getWorld().getCell(y, x));
	}
	
	/**
	 * returns the cell this LifeForm is in
	 */
	public Cell getCell()
	{
		return location;
	}

	public int getDirection()
	{
		return currentDirection;
	}
	public void turn(int d)
	{
		currentDirection = d;
	}
	public int getSpeed()
	{
		return speed;
	}
	public int getyLocation()
	{
		return location.getyLocation();
	}
	public int getxLocation()
	{
		return location.getxLocation();
	}
	
	
}
