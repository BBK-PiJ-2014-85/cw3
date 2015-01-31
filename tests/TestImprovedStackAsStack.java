package tests;

import cw3.ImprovedStackImpl;

/**
 * Class to test to Stack features of ImprovedStackImpl by extending TestStack 
 * and setting the field "stack" being tested to an instance of ImprovedStackImpl
 * 
 * 
 * @author Paul Day
 *
 */

public class TestImprovedStackAsStack extends TestStack{

	@Override
	public void createNewStack() {
		stack = new ImprovedStackImpl();
	}

}
