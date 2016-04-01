
/**
 * Test suite for all of the game tests
 */
import org.junit.runner.RunWith;

import org.junit.runners.Suite;

import Weapon.*;
import environment.*;
import gameplay.*;
import lifeform.*;
import recovery.*;

/**
 * 
 * Runs all of the tests in the project.
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class, TestRecoveryNone.class,
		TestRecoveryLinear.class, TestAlien.class, TestSimpleTimer.class, TestChainGun.class, TestStabilizer.class,
		TestWeapon.class, TestPlasmaCannon.class, TestPowerBooster.class, TestPistol.class, TestScope.class })

public class AllGameTests
{
	
}
