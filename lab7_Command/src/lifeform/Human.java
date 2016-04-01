/**
 * @author elliotlard
 * Class Human
 * Human is a subclass of life form which adds the armor functionality.
 */
package lifeform;

import environment.Environment;

public class Human extends LifeForm
{
	int armor;

	/*
	 * A human is constructed with an armor value as well as everything in a
	 * normal LifeForm.
	 */
	public Human(String name, int points, int a, int ad)
	{
		super(name, points, ad);
		armor = a;
		if (armor < 0)
		{
			armor = 0;
		}
		maxSpeed = 3;
	}
	public Human(String name, int points, int a)
	{
		this(name, points, a, 5);
	}
	public Human(String name, int points)
	{
		this(name, points, 0);
	}
	/*
	 * @param sets the armor to a
	 */
	public void setArmor(int a)
	{
		armor = a;
		if (armor < 0)
		{
			armor = 0;
		}
	}
	/*
	 * returns the armor value
	 */
	public int getArmor()
	{
		return armor;
	}
	
	public void takeHit(int damage)
	{
		if(armor < damage)
			super.takeHit(damage - armor);
	}
	@Override
	public void updateTime(int time)
	{
		// TODO Auto-generated method stub
		
	}
}
