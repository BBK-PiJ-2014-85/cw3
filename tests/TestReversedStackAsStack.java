package tests;

import interfaces.ImprovedStack;
import cw3.ImprovedStackImpl;

/**
 * Class tests Stack features of a reversed list provided from ImprovedStackImpl. This extends TestStack 
 * and sets the field "stack" being tested to an instance of an empty stack provided from reverse() fromImprovedStackImpl,
 * which tests the stack functionality is as expected.
 * 
 * Tests within TestImprovedStack tests methods on a reversed stack containing elements.
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
