import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * TODO:
 * 	- add clear comments to this class
 *  - fix last test to make sense Head()
 *  - reorder methods to make easier to follow
 *  - create as an abstract class so it can just be extended to test linked list as well
 *  - fix the bugs raised by the tests (the bounds issue) and consider the cloning further
 */


@RunWith(Parameterized.class)
public class TestArrayList {
	List list;

	int index;
	
	int resultSize;
	Boolean resultIsEmpty;
	Object resultFirstItem;
	Object resultSecondItem;
	Object resultThirdItem;
	Object resultFourthItem;
	Object resultFifthItem;
	Object resultLastItem;

	public List createStartingList()
	{
		return new ArrayList();
	}
	
	public TestArrayList(int index, String name)
	{
		this.index = index;
	}

	@Before
	public void resetList()
	{
		setCleanList(index);
	}
	

	public void setCleanList(int index)
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
	public static Collection<Object[]> createLists()
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
	

	
	@Test
	public void testIsEmpty() {
		assertEquals(list.isEmpty(), resultIsEmpty);
	}
	
	@Test
	public void testSize() {
		assertEquals(list.size(), resultSize);
	}
	
	@Test
	public void testCorrectErrorAndSizeOnAddNull() {
		assertEquals(list.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
		assertEquals(list.size(), resultSize);
		assertEquals(list.get(0).getReturnValue(), resultFirstItem);
	}
	
	@Test
	public void testAddItem() {
		assertEquals(list.add("Word added").getError(), ErrorMessage.NO_ERROR);
		assertEquals(resultSize + 1 , list.size());
		assertEquals(list.get(resultSize).getReturnValue(),"Word added");
	}
	
	@Test
	public void testGetNegativeIndexError()
	{
		assertEquals(list.get(-1).getError(), (resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE : ErrorMessage.INDEX_OUT_OF_BOUNDS) );
		assertEquals(resultSize, list.size());
	}
	 
	@Test
	public void testGetOverboundError()
	{
		assertEquals(list.get(resultSize).getError(), (resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.INDEX_OUT_OF_BOUNDS) );
		assertEquals(resultSize, list.size());
	}
	
	@Test
	public void testGetSecondItem()
	{
		assertEquals(list.get(1).getReturnValue(), resultSecondItem);
		assertEquals(resultSize, list.size());
		assertEquals(list.get(1).getReturnValue(), resultSecondItem);
		
	}
	
	@Test
	public void testGetFifthItem()
	{
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);
		assertEquals(resultSize, list.size());
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);	 
	}
	
	@Test
	public void testRemNegativeIndexError()
	{
		 assertEquals(list.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		 assertEquals(resultSize, list.size());
	}
	 
	@Test
	public void testRemOverboundError()
	{
		 assertEquals(list.remove(resultSize).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		 assertEquals(resultSize, list.size());
	}
	
	@Test
	public void testRemFirstItem()
	{
			assertEquals(list.remove(0).getReturnValue(), resultFirstItem);
			assertEquals(Math.max(resultSize - 1, 0), list.size());
			assertEquals(list.get(0).getReturnValue(), resultSecondItem);
	}
	
	@Test
	public void testRemFourthItem()
	{
		assertEquals(list.remove(3).getReturnValue(), resultFourthItem);
		assertEquals((resultFourthItem == null ? resultSize: resultSize - 1), list.size());
		assertEquals(list.get(3).getReturnValue(), resultFifthItem);	 

	}
	
	@Test
	public void testAddIndexErrorNegativeIndex()
	{
		assertEquals(list.add(-1, "item").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}
	
	@Test
	public void testAddIndexErrorUpperBoundIndex()
	{
		assertEquals(list.add(list.size(), "item").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
	}
	
	@Test
	public void testErrorMessageAddItemIndexAtZero()
	{
		assertEquals(list.add(0, "item").getError(), (resultIsEmpty ? ErrorMessage.INDEX_OUT_OF_BOUNDS : ErrorMessage.NO_ERROR));
	}
	
	@Test 
	public void testAddItemIndexAtZero()
	{
		list.add(0, "item");
		assertEquals(list.get(0).getReturnValue(), (resultIsEmpty ? null : "item"));
		assertEquals(list.get(1).getReturnValue(), resultFirstItem);
		assertEquals((resultIsEmpty ? resultSize : resultSize + 1), list.size());	
	}
	
	@Test 
	public void testAddItemIndexAtEnd()
	{
		if (!resultIsEmpty)
		{
			int end = resultSize - 1;
			list.add(end, "item");
			assertEquals(list.get(end).getReturnValue(),"item");
			assertEquals(list.get(end + 1).getReturnValue(), resultLastItem);
			assertEquals(end + 2, list.size());
		}
	}
	
	@Test 
	public void testAddItemIndexAtSecondPoint()
	{
		list.add(1,"item");
		assertEquals(list.get(1).getReturnValue(), ( resultSize <= 1 ? null : "item"));
		assertEquals(list.get(2).getReturnValue(), resultSecondItem);
		assertEquals(list.get(3).getReturnValue(), resultThirdItem);
		assertEquals(list.get(4).getReturnValue(), resultFourthItem);
		assertEquals(list.get(5).getReturnValue(), resultFifthItem);
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
	/*
	@Test
	public void testHeadEmptyError()
	{
		assertEquals( list.head().getError(), (resultIsEmpty? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.NO_ERROR));
	}
	
	@Test
	public void testHeadReturnItem()
	{		
		assertEquals(list.head().getReturnValue(), resultFirstItem);
	}
	
	@Test
	public void testListUnchangedAfterHead()
	{
		list.head();
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
		assertEquals((resultSize <= 1? true : false), list.rest().isEmpty());	
	}
	
	@Test
	public void testRestValues()
	{
		FunctionalList restList = list.rest();
		assertEquals(resultSecondItem, restList.get(0).getReturnValue());
		assertEquals(resultThirdItem, restList.get(1).getReturnValue());
		assertEquals(resultFourthItem, restList.get(2).getReturnValue());
		assertEquals(resultFifthItem, restList.get(3).getReturnValue());
		assertNull(restList.get(4).getReturnValue());
	}
	
	@Test
	public void testListUnchangedOnRest()
	{
		list.rest();
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
	
*/
}



