package lifeform;

public class MockLifeForm extends LifeForm
{
	public MockLifeForm(String name, int points, int ad)
	{
		super(name, points, ad);
		maxSpeed = 3;
	}
	public MockLifeForm(String name, int points)
	{
		this(name, points, 10);
	}
	@Override
	public void updateTime(int time)
	{
		// TODO Auto-generated method stub
		
	}
	public void setAttackStrength(int ad)
	{
		attackStrength = ad;
		
	}

}
