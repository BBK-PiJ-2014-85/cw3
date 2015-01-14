
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * This contains the tests for for the methods of FunctionalList extra to those already in List.
 * 
 * This extends the class TestList, which tests the methods FunctionalList inherits from List.
 * 
 * The class TestList also contains different types of lists that are sent through all these tests as parameters.
 * 
 * This class is abstract as it will be extended for each specific type of FunctionalList, which will be defined by the 
 * createStartingList() method as required by the extended TestList.
 * 
 */

public abstract class TestFunctionalList extends TestList{
	
	public TestFunctionalList(int index, String name) {
		super(index, name);
	}

	@Test
	public void testHeadEmptyError()
	{
		assertEquals( ((FunctionalList) list).head().getError(), (resultIsEmpty? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.NO_ERROR));
	}
	
	@Test
	public void testHeadReturnItem()
	{		
		assertEquals(((FunctionalList) list).head().getReturnValue(), resultFirstItem);
	}
	
	@Test
	public void testListUnchangedAfterHead()
	{
		((FunctionalList) list).head();
		assertEquals(list.size(), resultSize);
		assertEquals(list.get(0).getReturnValue(), resultFirstItem);
		assertEquals(list.get(1).getReturnValue(), resultSecondItem);
		assertEquals(list.get(2).getReturnValue(), resultThirdItem);
		assertEquals(list.get(3).getReturnValue(), resultFourthItem);
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);
	}
	
	@Test
	public void testListNotAlteredByChangesToReturnedHead()
	{
		FunctionalList testList = new FunctionalArrayList();
		String[] testArray = new String [] {"original","two"};
		testList.add(testArray);
		String[] newObject = (String[]) testList.head().getReturnValue();
		newObject[0] = "changed";
		assertEquals(((String[])testList.head().getReturnValue())[0], "original");
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
		FunctionalList testList = new FunctionalArrayList();
		String[] testArray = new String [] {"original","two"};
		testList.add(1);
		testList.add(testArray);
		testList.add(60);
		FunctionalList restList = testList.rest();
		restList.add(4);
		restList.remove(0);
		assertEquals(list.get(0).getReturnValue(), resultFirstItem);
		assertEquals(testList.get(0).getReturnValue(), resultSecondItem);
		assertEquals(testList.get(0).getReturnValue(), resultThirdItem);

	}
}




