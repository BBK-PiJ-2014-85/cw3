package tests;

import cw3.ImprovedStack;
import cw3.ImprovedStackImpl;

/**
 * Class to test Stack features of a reversed list provided from ImprovedStackImpl. This extends TestStack 
 * and sets the field "stack" being tested to an instance of an empty stack provided from reverse() fromImprovedStackImpl,
 * which tests the stack functionality is as expected.
 * 
 * Tests within TestImprovedStack test methods on a reversed stack containing elements functions as expected.
 * 
 * @author Paul Day
 *
 */

public class TestReversedStackAsStack extends TestStack {

	@Override
	public void createNewStack() {
		ImprovedStack tempStack = new ImprovedStackImpl();
		stack = tempStack.reverse();
	}

}
