package tests;

import cw3.ImprovedStackImpl;

/**
 * Class to test to Stack methods of ImprovedStackImpl by extending the test class TestStack.
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
