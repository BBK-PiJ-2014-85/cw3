
package tests;

import cw3.ErrorMessage;
import cw3.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * Abstract class which contains the tests for testing the Stack implementation. This allows different stack implementations
 * to be tested in different classes, without repeating code.
 * 
 * This should be extended by a test which creates has the method createNewStack() which must define
 * stack = new StackImplementedToBeTested();
 * 
 * 
 * @author Paul Day
 *
 */

public abstract class TestStack {

	Stack stack; //Empty stack to start each test. Defined by createNewStack()
	
	/**
	 * This method must be defined in each test implementations of Stack. This must define stack to be a new instance of the
	 * class to be implemented. 
	 * 
	 * For example if we wish to test a class StackImpl the code would be stack= new StackImpl();
	 * 
	 */
	
	@Before
	public abstract void createNewStack();

	
	@Test
	public void testIsEmptyOnEmpty()
	{
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testZeroSizeOnStart()
	{
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testSizeAddOne()
	{
		stack.push("Object");
		assertEquals(1,stack.size());
	}
	
	@Test
	public void testIsEmptyAddOne()
	{
		stack.push(1);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testSizeAddOneRemoveOne()
	{
		stack.push(1);
		stack.pop();
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testIsEmptyAddOneRemoveOne()
	{
		stack.push(1);
		stack.pop();
		assertTrue(stack.isEmpty());		
	}
	
	@Test
	public void testSizeForAddMany()
	{
		int numRuns = 1000;
		for (int i=1; i <= numRuns; i++) stack.push(numRuns);
		assertEquals(numRuns,stack.size());
	}
	
	@Test
	public void testSizeZeroWhenTopNothing()
	{
		stack.top();
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testSizeZeroWhenPopNothing()
	{
		stack.pop();
		assertEquals(0,stack.size());
	}	
	
	@Test
	public void testSizeAfterTop()
	{
		stack.push(1);
		stack.push(2);
		stack.top();
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testSizeAfterPop()
	{
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1,stack.size());
	}
	
	@Test
	public void testErrorPoppingEmpty()
	{
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testErrorToppingEmpty()
	{
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.top().getError());
	}
	
	@Test
	public void testErrorPoppingEmptyAfterAddAndRemove()
	{
		stack.push(1);
		stack.pop();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testErrorToppingEmptyAfterAddAndRemove()
	{
		stack.push(1);
		stack.pop();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.top().getError());
	}
	
	@Test
	public void testNoErrorPoppingNotEmpty()
	{
		stack.push(1);
		assertEquals(ErrorMessage.NO_ERROR,stack.pop().getError());
	}
	
	@Test
	public void testNoErrorToppingNotEmpty()
	{
		stack.push(1);
		assertEquals(ErrorMessage.NO_ERROR,stack.top().getError());
	}
	
	@Test
	public void testSizeDecreaseOnPop()
	{
		stack.push(0);
		stack.push(1);
		stack.push(2);
		assertEquals(3,stack.size());
		
		stack.pop();
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testPopReturnsCorrectValueInteger()
	{
		stack.push(1);
		stack.push(2);
		assertEquals(2,stack.pop().getReturnValue());
	}
	
	@Test
	public void testPopReturnCorrectValueComplex()
	{
		stack.push(1);
		Object[] complexObject = new Object[] {1,"two"};
		stack.push(complexObject);
		assertEquals(complexObject, stack.pop().getReturnValue());		
	}

	@Test
	public void testTopReturnsCorrectValueInteger()
	{
		stack.push(1);
		stack.push(2);
		assertEquals(2,stack.top().getReturnValue());
	}
	
	@Test
	public void testTopReturnCorrectValueComplex()
	{
		stack.push(1);
		Object[] complexObject = new Object[] {1,"two"};
		stack.push(complexObject);
		assertEquals(complexObject, stack.top().getReturnValue());
	}
	
	@Test
	public void testStackValuesUnchangedOnTop()
	{
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.top();
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
		assertEquals(0,stack.pop().getReturnValue());
	}
	
	@Test
	public void testAddAndPopMultipleReturnsCorrectOrder()
	{
		stack.push(0);
		stack.push(1);
		stack.push(2);
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
		assertEquals(0,stack.pop().getReturnValue());
	}

}
