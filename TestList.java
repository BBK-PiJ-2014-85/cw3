import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * This class contains the following:
 * 		- tests for methods within List
 * 		- multiple types of lists as different parameters and therefore the tests are run for all of these types of list
 * 
 * This is an abstract class, which is extended for different list types by defining the createStartingList() method.
 * 
 */

/*
 * TODO: add method to check all elememnts and size to avoid repetition
 * 		- add final methods to testFunctionalList
 */

@RunWith(Parameterized.class)
public abstract class TestList {
	
	List list; // This holds the list currently being tested
	
	int index; // Index references which list is currently being tested from list of parameters
	
	// The methods with names starting with "result" are where the expected results for the current list being tested
	int resultSize;
	Boolean resultIsEmpty;
	Object resultFirstItem;
	Object resultSecondItem;
	Object resultThirdItem;
	Object resultFourthItem;
	Object resultFifthItem;
	Object resultLastItem;

	
	public abstract List createStartingList(); // Returns an empty list of the type of list to test, as defined within classes extending this one.

	
	public TestList(int index, String name) // Updates the indexID for the current list being tested, and reads in name to be displayed within the test results
	{
		this.index = index;
	}

	@Before
	public void resetList() // Resets the list being run to its initial state before being tested by every method 
	{
		setCleanList(index);
	}
	

	public void setCleanList(int index) // Defines and returns each list, called by its index, in its initial state.
	{			
		list = createStartingList();
		if (index == 0) // Create an empty list
		{
			setElements(0, true, null,null,null,null,null, null);
		}
		if (index == 1) // Create a list with two elements
		{
			list.add("First");
			list.add("Second");
			setElements(2, false, "First", "Second",null,null,null,"Second");
		}
		else if (index == 2) // Create a list with one element, which also tests a complex type (String[])
		{
			String[] oneElementItem = new String[] {"first","second"};
			list.add(oneElementItem);			
			setElements(1, false, oneElementItem,null,null,null,null, oneElementItem);
		}
		else if (index == 3) // Create a list which has had an element added then removed, to leave an empty list
		{
			list.add(1);
			list.remove(0);		
			setElements(0, true, null,null,null,null,null,null);
		}
		else if (index == 4) // Create a list which has had an element added and removed, and then has an "out of bounds" error caused by the remove() method
		{
			list.add("Entry");
			list.remove(0);
			list.remove(-1);
			setElements(0, true, null,null,null,null,null, null);
		}
		else if (index == 5) // Create a list which has had an element added and removed, and then has an "out of bounds" error caused by the get() method
		{
			list.add("Entry");
			list.remove(0);
			list.get(-1);
			setElements(0, true, null,null,null,null,null, null);
		}
		else if (index == 6) //Create a list which has had a null added to it
		{
		list.add(null);
		setElements(0, true, null,null,null,null,null, null);
		}
		else if (index == 7) // Create a list which has had an element added and removed, then theempty_structure error trying to remove() from an empty list
		{
			list.add("Entry");
			list.remove(0);
			list.remove(0);
			setElements(0, true, null,null,null,null,null, null);
		}
		else if (index == 8) // Create a list which has had an element added and removed, then the empty_structure error trying to get() from an empty list
		{
			list.add("Entry");
			list.remove(0);
			list.get(0);
			setElements(0, true, null,null,null,null,null, null);
		}
		else if (index == 9) // Create a list which has had two elements added, then an OOB (under bounds) from the remove() leaving a non-empty list
		{
			list.add(1);
			list.add(2);
			list.remove(-1);
			setElements(2, false, 1,2,null,null,null, 2);
		}
		else if (index == 10) // Create a list which has had two elements added, then an OOB error (under bounds) from the get() leaving a non-empty list
		{
		list.add(1);
		list.add(2);
		list.get(-1);
		setElements(2, false, 1,2,null,null,null, 2);
		}
		else if (index == 11) // Create a list which has had two elements added, then an OOB error (over bounds) from the remove() leaving a non-empty list
		{
		list.add(1);
		list.add(2);
		list.remove(3);
		setElements(2, false, 1,2,null,null,null, 2);
		}
		else if (index == 12) // Create a list which has had two elements added, then an OOB error (over bounds) from the get() leaving a non-empty list
		{
		list.add(1);
		list.add(2);
		list.get(3);
		setElements(2, false, 1,2,null,null,null, 2);
		}
		else if (index == 13) // Create a list which has two elements followed by attempting to add a null
		{
		list.add("word");
		list.add(123456789);
		list.add(null);
		setElements(2, false, "word",123456789,null,null,null, 123456789);
		}
		else if (index == 14) // Create a list with 3 elements
		{
			list.add("first");
			list.add("second");
			list.add(3);
			setElements(3, false, "first","second",3,null,null, 3);
		}
		else if (index == 15) // Create a list with 4 elements (especially important to check arraylist correctly enlarges arrays)
		{
			list.add("first");
		list.add("second");
		list.add(3);
		list.add(4);
		setElements(4, false, "first","second",3,4,null, 4);
		}
		else if (index == 16) // Create a list with 5 elements, and also a complex element type (an Object[])
		{
		list.add(1);
		list.add("two");
		list.add(3.00);
		Object[] fourthItem = new Object[] {4,"th entry"};
		list.add(fourthItem);
		list.add(5);
		setElements(5, false, 1,"two",3.00,fourthItem,5, 5);
		}
	}
	
	private void setElements(int size, boolean isEmpty, Object one, Object two, Object three, Object four, Object five, Object last) 
	{
		/*
		 *  This sets expected results to initial state for each run. These aren't altered by any tests, but as new lists are created
		 *  between each run, identical complex elements of lists would point to a different location on recreation and so this ensures they
		 *  remain pointing to the same location.
		 *  
		 */
			
		resultSize = size;
		resultIsEmpty = isEmpty;
		resultFirstItem = one;
		resultSecondItem = two;
		resultThirdItem = three;
		resultFourthItem = four;
		resultFifthItem = five;
		resultLastItem = last;
	}
	
	@Parameters(name = "{1}")
	public static Collection<Object[]> createLists() //Holds the description and index number for each list to be tested.Must align to setCleanList()
	{	
		
	Object [][] data= new Object[][]
			{
			{0,"Empty List"},
			{1,"Two Elements"},
			{2,"One Element"},
			{3,"Empty having one entry removed"},
			{4,"Empty after removing one and an OOB error"},
			{5,"Empty after triggering OOB error"},
			{6,"Empty after triggering null entry error"},
			{7,"Empty after removing one and an remove empty error"},
			{8,"Empty after get() error having removed one element"},
			{9,"Two elements after high OOB error by remove()"},
			{10,"Two elements after low OOB error by remove()"},
			{11,"Two elements after high OOB error by get()"},
			{12,"Two elements after low OOB error by get()"},
			{13,"Two elememnts after null error"},
			{14,"Three Elements"},
			{15,"Four Elements"},
			{16,"Five Elements"}
			};
	return Arrays.asList(data);
	
}
	
// BELOW ARE THE TEST METHODS
	
	@Test
	public void testIsEmpty() {
		assertEquals(resultIsEmpty, list.isEmpty());
	}
	
	@Test
	public void testSize() {
		assertEquals(resultSize, list.size());
	}
	
	@Test
	public void testCorrectErrorAndSizeOnAddNull() {
		assertEquals(ErrorMessage.INVALID_ARGUMENT, list.add(null).getError());
		assertEquals(resultSize, list.size());
		assertEquals(resultFirstItem, list.get(0).getReturnValue());
	}
	
	@Test
	public void testAddItem() {
		assertEquals(ErrorMessage.NO_ERROR, list.add("Word added"));
		assertEquals(resultSize + 1 , list.size());
		assertEquals("Word added", list.get(resultSize).getReturnValue());
	}
	
	@Test
	public void testGetNegativeIndexError()
	{
		assertEquals((resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE : ErrorMessage.INDEX_OUT_OF_BOUNDS), list.get(-1).getError());
		assertEquals(resultSize, list.size());
	}
	 
	@Test
	public void testGetOverboundError()
	{
		assertEquals((resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.INDEX_OUT_OF_BOUNDS) ,list.get(resultSize).getError());
		assertEquals(resultSize, list.size());
	}
	
	@Test
	public void testGetSecondItem()
	{
		assertEquals(resultSecondItem, list.get(1).getReturnValue());
		assertEquals(resultSize, list.size());
		assertEquals(resultSecondItem, list.get(1).getReturnValue());
		
	}
	
	@Test
	public void testGetFifthItem() //this is particularly of interest as it involved the array to be expanded for arraylist
	{
		assertEquals(resultFifthItem, list.get(4).getReturnValue());
		assertEquals(resultSize, list.size());
		assertEquals(resultFifthItem, list.get(4).getReturnValue());	 
	}
	
	@Test
	public void testRemNegativeIndexError()
	{
		 assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.remove(-1).getError());
		 assertEquals(resultSize, list.size());
	}
	 
	@Test
	public void testRemOverboundError()
	{
		 assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.remove(resultSize).getError());
		 assertEquals(resultSize, list.size());
	}
	
	@Test
	public void testRemFirstItem()
	{
			assertEquals(resultFirstItem, list.remove(0).getReturnValue());
			assertEquals(Math.max(resultSize - 1, 0), list.size());
			assertEquals(resultSecondItem, list.get(0).getReturnValue());
	}
	
	@Test
	public void testRemFourthItem()
	{
		assertEquals(resultFourthItem, list.remove(3).getReturnValue());
		assertEquals((resultFourthItem == null ? resultSize: resultSize - 1), list.size());
		assertEquals( resultFifthItem,list.get(3).getReturnValue());	 

	}
	
	@Test
	public void testAddIndexErrorNegativeIndex()
	{
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.add(-1, "item").getError());
	}
	
	@Test
	public void testAddIndexErrorUpperBoundIndex()
	{
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.add(list.size(), "item").getError());
	}
	
	@Test
	public void testErrorMessageAddItemIndexAtZero()
	{
		assertEquals((resultIsEmpty ? ErrorMessage.INDEX_OUT_OF_BOUNDS : ErrorMessage.NO_ERROR), list.add(0, "item").getError());
	}
	
	@Test 
	public void testAddItemIndexAtZero()
	{
		list.add(0, "item");
		assertEquals((resultIsEmpty ? null : "item"), list.get(0).getReturnValue());
		assertEquals(resultFirstItem, list.get(1).getReturnValue());
		assertEquals((resultIsEmpty ? resultSize : resultSize + 1), list.size());	
	}
	
	@Test 
	public void testAddItemIndexAtEnd()
	{
		if (!resultIsEmpty)
		{
			int end = resultSize - 1;
			list.add(end, "item");
			assertEquals("item",list.get(end).getReturnValue());
			assertEquals(resultLastItem,list.get(end + 1).getReturnValue());
			assertEquals(end + 2, list.size());
		}
	}
	
	@Test 
	public void testAddItemIndexAtSecondPoint()
	{
		list.add(1,"item");
		assertEquals(( resultSize <= 1 ? null : "item"), list.get(1).getReturnValue());
		assertEquals(resultSecondItem, list.get(2).getReturnValue());
		assertEquals(resultThirdItem, list.get(3).getReturnValue());
		assertEquals(resultFourthItem, list.get(4).getReturnValue());
		assertEquals(resultFifthItem, list.get(5).getReturnValue());
	}

	@Test
	public void testManyElements()
	{
		int testAmount = 10000;
		for (int i = 0; i < testAmount; i++)
		{
			list.add(i);
		}
		
		assertEquals(resultSize + testAmount , list.size());	
	}

}



