
package tests;

import interfaces.ErrorMessage;
import cw3.ImprovedStackImpl;
import interfaces.ImprovedStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
/**
 * This class tests the ImprovedStack methods for the implementation ImprovedStackImpl.
 * 
 * Test of the Stack methods (i.e. those inherited by improved stack) for this class can be found in the test class TestImprovedStackAsStack.
 * Test of Stack methods for the returned "reverse()" stack can be found in TestReversedStackAsStack.
 * 
 * @author Paul Day
 *
 */

public class TestImprovedStack {

	ImprovedStack stack;
	ImprovedStack reversedStack;
	
	@Before
	public void createNewStack()
	{
		stack = new ImprovedStackImpl();
		reversedStack=null;
	}
	
	@Test
	public void testOriginalSizeAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testOriginalIsEmptyAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testOriginalErrorIsEmptyAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testCopySizeAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertEquals(0,reversedStack.size());
	}
	
	@Test
	public void testCopyIsEmptyAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertTrue(reversedStack.isEmpty());
	}
	
	@Test
	public void testCopyErrorIsEmptyAfterReverseOnEmpty()
	{
		reversedStack = stack.reverse();
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,reversedStack.pop().getError());
	}
	
	@Test
	public void testReverseItemsReversed()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		assertEquals(1,reversedStack.pop().getReturnValue());
		assertEquals(2,reversedStack.pop().getReturnValue());
		assertEquals(3,reversedStack.pop().getReturnValue());
	}
	
	@Test
	public void testReversedStackTop()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		reversedStack.top();
		assertEquals(1,reversedStack.top().getReturnValue());
	}
	
	@Test
	public void testPushOnReversedStack()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		reversedStack.push(4);
		
		assertEquals(4,reversedStack.top().getReturnValue());
	}
	
	@Test
	public void testSizeOnReverseItems()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		assertEquals(3,reversedStack.size());
	}
	
	@Test
	public void testOriginalEntriesSameAfterReverse()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}
	
	@Test
	public void testOriginalSizeSameAfterReverse()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		assertEquals(3,stack.size());
	}
	
	@Test
	public void testOriginalEntriesSameAfterAlteringReverse()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		reversedStack.pop();
		reversedStack.pop();
		reversedStack.pop();
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}
	
	@Test
	public void testOriginalSizeSameAfterAlteringReverse()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reversedStack = stack.reverse();
		
		reversedStack.pop();
		reversedStack.pop();
		reversedStack.pop();
		
		assertEquals(3,stack.size());
	}
	
	@Test
	public void testNothingErrorsOnRemoveNull()
	{
		stack.push(1);
		stack.remove(null);
	}

	@Test
	public void testNothingChangesInStackOnRemoveNull()
	{
		stack.push(1);
		stack.remove(null);
		
		assertEquals(1,stack.size());
		assertEquals(1,stack.top().getReturnValue());
	}
	
	@Test
	public void testSizeAfterRemoveFirstItemPassedToStack()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(1);
		
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testEntriesAfterRemoveFirstItemPassedToStack()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(1);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testSizeAfterRemoveMiddleItem()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(2);
		
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testEntriesAfterRemoveMiddleItem()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(2);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testSizeAfterRemoveLastItemAdded()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(3);
		
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
	}
	
	@Test
	public void testEntriesAfterRemoveLastItemAdded()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(3);
		
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testSameSizeAfterRemoveNotFound()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(4);
		
		assertEquals(3,stack.size());
	}
	
	@Test
	public void testSameEntriesAfterRemoveNotFound()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.remove(4);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(2,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}

	
	@Test
	public void testSizeAfterRemoveMultipleEntries()
	{
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		
		stack.remove(2);
		
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testEntriesAfterRemoveMultipleEntries()
	{
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		
		stack.remove(2);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}
	
	@Test
	public void testSizeAfterRemoveMultipleEntriesFirstAndLast()
	{
		stack.push(2);
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(2);
		
		stack.remove(2);
		
		assertEquals(2,stack.size());
	}
	
	
	@Test
	public void testEntriesAfterRemoveMultipleEntriesFirstAndLast()
	{
		stack = new ImprovedStackImpl();
		stack.push(2);
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(2);
		
		stack.remove(2);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}
	
	@Test
	public void testSizeRemovingMultipleValues()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.remove(2);
		stack.remove(4);
		
		assertEquals(2,stack.size());
	}
	
	@Test
	public void testEntriesRemovingMultipleValues()
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.remove(2);
		stack.remove(4);
		
		assertEquals(3,stack.pop().getReturnValue());
		assertEquals(1,stack.pop().getReturnValue());
	}
	
	@Test
	public void testSizeAfterRemoveComplexItem()
	{
		Object[] complexItem = new Object[] {1,"two"};
		
		stack.push(1);
		stack.push(complexItem);
		
		stack.remove(complexItem);
		
		assertEquals(1,stack.size());
	}

	@Test
	public void testEntriesAfterRemoveComplexItem()
	{
		Object[] complexItem = new Object[] {1,"two"};
		
		stack.push(1);
		stack.push(complexItem);
		
		stack.remove(complexItem);
		
		assertEquals(1,stack.pop().getReturnValue());
	}


	@Test
	public void testSizeAfterRemovedAll()
	{
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		
		stack.remove(1);
		
		assertEquals(0,stack.size());
	}
	
	@Test
	public void testIsEmptyAfterRemoveAll()
	{
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		
		stack.remove(1);
		
		assertTrue(stack.isEmpty());
	}
	
	
}
