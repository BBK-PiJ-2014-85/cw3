package tests;

import cw3.StackImpl;

/**
 * Class to test StackImpl by extending TestStack and setting the field "stack" being tested to an instance of StackImpl
 * 
 * 
 * @author Paul Day
 *
 */

public class TestStackImpl extends TestStack{

	@Override
	public void createNewStack() {
		stack = new StackImpl();
	}

}
