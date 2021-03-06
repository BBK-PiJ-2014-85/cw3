
package tests;

import interfaces.ErrorMessage;
import interfaces.FunctionalList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This contains the tests for for the methods of FunctionalList extra to those already in List.
 * 
 * This extends the class TestList, which tests the methods FunctionalList inherits from List.
 * 
 * The class TestList also contains different types of lists that are sent through all these tests as parameters.
 * 
 * This class is abstract as it will be extended for each specific type of FunctionalList, which will be defined by the 
 * createStartingList() method as required by the extended TestList.
 * 
 * 
 * @author Paul Day
 *
 */

public abstract class TestFunctionalList extends TestList{
	
	public TestFunctionalList(int index, String name) {
		super(index, name);
	}

	@Test
	public void testHeadEmptyError()
	{
		assertEquals((resultIsEmpty? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.NO_ERROR), ((FunctionalList) list).head().getError());
	}
	
	@Test
	public void testHeadReturnItem()
	{		
		assertEquals(resultFirstItem, ((FunctionalList) list).head().getReturnValue());
	}
	
	@Test
	public void testListUnchangedAfterHead()
	{
		((FunctionalList) list).head();
		assertEquals(resultSize,list.size());
		assertEquals(resultFirstItem, list.get(0).getReturnValue());
		assertEquals(resultSecondItem, list.get(1).getReturnValue());
		assertEquals(resultThirdItem, list.get(2).getReturnValue());
		assertEquals(resultFourthItem, list.get(3).getReturnValue());
		assertEquals(resultFifthItem, list.get(4).getReturnValue());
	}
	
	@Test
	public void testRestReturnEmpty()
	{
		assertEquals((resultSize <= 1? true : false), ((FunctionalList) list).rest().isEmpty());	
	}
	
	@Test
	public void testRestValues()
	{
		FunctionalList restList = ((FunctionalList) list).rest();
		assertEquals(resultSecondItem, restList.get(0).getReturnValue());
		assertEquals(resultThirdItem, restList.get(1).getReturnValue());
		assertEquals(resultFourthItem, restList.get(2).getReturnValue());
		assertEquals(resultFifthItem, restList.get(3).getReturnValue());
		assertNull(restList.get(4).getReturnValue());
	}
	
	@Test
	public void testListUnchangedOnRest()
	{
		((FunctionalList) list).rest();
		assertEquals(resultFirstItem, list.get(0).getReturnValue());
		assertEquals(resultSecondItem, list.get(1).getReturnValue());
		assertEquals(resultThirdItem, list.get(2).getReturnValue());
		assertEquals(resultFourthItem, list.get(3).getReturnValue());
		assertEquals(resultFifthItem, list.get(4).getReturnValue());
	}
	
	@Test 
	public void testRestNotEffectOriginalList()
	{
		FunctionalList restList = ((FunctionalList) list).rest();
		
		restList.add(1);
		restList.add(2);
		restList.remove(0);
		
		assertEquals(resultSize, list.size());
		assertEquals(resultFirstItem, list.get(0).getReturnValue());
		assertEquals(resultSecondItem, list.get(1).getReturnValue());
		assertEquals(resultThirdItem, list.get(2).getReturnValue());
		assertEquals(resultFourthItem, list.get(3).getReturnValue());
		assertEquals(resultFifthItem, list.get(4).getReturnValue());
	}

}




