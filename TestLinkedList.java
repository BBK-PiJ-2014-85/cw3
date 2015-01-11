import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

	FunctionalList list;
	Object[][] tests;
	
	int resultSize;
	Boolean resultIsEmpty;
	Object resultFirstItem;
	Object resultSecondItem;
	Object resultThirdItem;
	Object resultFourthItem;
	Object resultFifthItem;
	Object resultLastItem;
	
	@Before
	public void setUpList() {
		FunctionalList emptyList = new FunctionalLinkedList();
		
		FunctionalList twoElements = new FunctionalLinkedList();
			twoElements.add("First");
			twoElements.add("Second");
			
		FunctionalList oneElement = new FunctionalLinkedList();
			String[] oneElementItem = new String[] {"first","second"};
			oneElement.add(oneElementItem);
		
		FunctionalList emptyAfterOneRemoved = new FunctionalLinkedList();
			emptyAfterOneRemoved.add(1);
			emptyAfterOneRemoved.remove(0);
		
		FunctionalList emptyAfterRemOOBError = new FunctionalLinkedList();
			emptyAfterRemOOBError.add("Entry");
			emptyAfterRemOOBError.remove(0);
			emptyAfterRemOOBError.remove(-1);
		
		FunctionalList emptyAfterGetOOBError = new FunctionalLinkedList();
			emptyAfterGetOOBError.add("Entry");
			emptyAfterGetOOBError.remove(0);
			emptyAfterGetOOBError.get(-1);
		
		FunctionalList emptyAfterNullError = new FunctionalLinkedList();;
			emptyAfterNullError.add(null);
		
		FunctionalList emptyAfterRemRetreiveEmpty = new FunctionalLinkedList();;
			emptyAfterRemRetreiveEmpty.add("Entry");
			emptyAfterRemRetreiveEmpty.remove(0);
			emptyAfterRemRetreiveEmpty.remove(0);
		
		FunctionalList emptyAfterGetRetreiveEmpty = new FunctionalLinkedList();;
			emptyAfterGetRetreiveEmpty.add("Entry");
			emptyAfterGetRetreiveEmpty.remove(0);
			emptyAfterGetRetreiveEmpty.get(0);
		
		FunctionalList twoElementsAfterOOBRemLowError = new FunctionalLinkedList();
			twoElementsAfterOOBRemLowError.add(1);
			twoElementsAfterOOBRemLowError.add(2);
			twoElementsAfterOOBRemLowError.remove(-1);
			
		FunctionalList twoElementsAfterOOBGetLowError = new FunctionalLinkedList();
			twoElementsAfterOOBGetLowError.add(1);
			twoElementsAfterOOBGetLowError.add(2);
			twoElementsAfterOOBGetLowError.get(-1);
		
		FunctionalList twoElementsAfterOOBRemHighError = new FunctionalLinkedList();
			twoElementsAfterOOBRemHighError.add(1);
			twoElementsAfterOOBRemHighError.add(2);
			twoElementsAfterOOBRemHighError.remove(3);
			
		FunctionalList twoElementsAfterOOBGetHighError = new FunctionalLinkedList();
			twoElementsAfterOOBGetHighError.add(1);
			twoElementsAfterOOBGetHighError.add(2);
			twoElementsAfterOOBGetHighError.get(3);
		
		FunctionalList twoElementsAfterNullError = new FunctionalLinkedList();
			twoElementsAfterNullError.add("word");
			twoElementsAfterNullError.add(123456789);
			twoElementsAfterNullError.add(null);
		
		FunctionalList threeElements = new FunctionalLinkedList();
			threeElements.add("first");
			threeElements.add("second");
			threeElements.add(3);
		
		FunctionalList fourElements = new FunctionalLinkedList();
			fourElements.add("first");
			fourElements.add("second");
			fourElements.add(3);
			fourElements.add(4);
		
		FunctionalList fiveElements = new FunctionalLinkedList();
			fiveElements.add(1);
			fiveElements.add("two");
			fiveElements.add(3.00);
			Object[] fourthItem = new Object[] {4,"th entry"};
			fiveElements.add(fourthItem);
			fiveElements.add(5);
			
		tests= new Object[][]
				{
				{emptyList,0, true, null,null,null,null,null,null},
				{twoElements,2,false,"First","Second",null,null,null,"Second"},
				{oneElement,1,false,oneElementItem,null,null,null,null,oneElementItem},
				{emptyAfterOneRemoved,0,true,null,null,null,null,null,null},
				{emptyAfterRemOOBError,0, true, null,null,null,null,null,null},
				{emptyAfterGetOOBError,0, true, null,null,null,null,null,null},
				{emptyAfterNullError,0, true, null,null,null,null,null,null},
				{emptyAfterRemRetreiveEmpty,0, true, null,null,null,null,null,null},
				{emptyAfterGetRetreiveEmpty,0, true, null,null,null,null,null,null},
				{twoElementsAfterOOBRemHighError,2,false,1,2,null,null,null,2},
				{twoElementsAfterOOBRemLowError,2,false,1,2,null,null,null,2},
				{twoElementsAfterOOBGetHighError,2,false,1,2,null,null,null,2},
				{twoElementsAfterOOBGetLowError,2,false,1,2,null,null,null,2},
				{twoElementsAfterNullError,2,false,"word",123456789,null,null,null,123456789},
				{threeElements,3,false,"first","second",3,null,null,3},
				{fourElements,4,false,"first","second",3,4,null,4},
				{fiveElements,5,false,1,"two",3.00,fourthItem,5,5}
				};

	}
	
		private void assignValues(Object[] test)
		{
			list = (FunctionalList) test[0];
			resultSize = (int) test[1];
			resultIsEmpty = (boolean) test[2];
			resultFirstItem = test[3];
			resultSecondItem = test[4];
			resultThirdItem = test[5];
			resultFourthItem = test[6];
			resultFifthItem = test[7];
			resultLastItem = test[8];
		}
	

	
	
	
	@Test
	public void testIsEmpty() {
		
		for (Object[] test : tests)
		{
		assignValues(test);
			
		assertEquals(list.isEmpty(), resultIsEmpty);
		}
		
	}
	
	@Test
	public void testSize() {
		for (Object[] test : tests)
		{
		assignValues(test);
		
		assertEquals(list.size(), resultSize);
		}
	}
	
	@Test
	public void testCorrectErrorAndSizeOnAddNull() {
		
		for (Object[] test : tests)
		{
		assignValues(test);
		
		int before = list.size();
		
		assertEquals(list.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
		assertEquals(list.size(), before);
		assertEquals(list.get(0).getReturnValue(), resultFirstItem);
		}
	}
	
	@Test
	public void testAddItem() {
		for (Object[] test : tests)
		{
		assignValues(test);
		int before = list.size();
		
		assertEquals(list.add("Word added").getError(), ErrorMessage.NO_ERROR);
		assertEquals(list.size(),resultSize + 1);
		assertEquals(list.get(before).getReturnValue(),"Word added");
		}
	}
	
	@Test
	public void testGetNegativeIndexError()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		
		int before = list.size();
		 assertEquals(list.get(-1).getError(), (resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE : ErrorMessage.INDEX_OUT_OF_BOUNDS) );
		 assertEquals(before, list.size());
		}
	}
	 
	@Test
	public void testGetOverboundError()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int upperBound = list.size();
		 assertEquals(list.get(upperBound).getError(), (resultIsEmpty ? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.INDEX_OUT_OF_BOUNDS) );
		 assertEquals(upperBound, list.size());
		}
	}
	
	@Test
	public void testGetSecondItem()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
			int before = list.size();
			assertEquals(list.get(1).getReturnValue(), resultSecondItem);
			assertEquals(before, list.size());
			assertEquals(list.get(1).getReturnValue(), resultSecondItem);
		}
	}
	
	@Test
	public void testGetFifthItem()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int before = list.size();
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);
		assertEquals(before, list.size());
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);	 
		}
	}
	
	@Test
	public void testRemNegativeIndexError()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int before = list.size();
		 assertEquals(list.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		 assertEquals(before, list.size());
		}
	}
	 
	@Test
	public void testRemOverboundError()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int upperBound = list.size();
		 assertEquals(list.remove(upperBound).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		 assertEquals(upperBound, list.size());
		}
	}
	
	@Test
	public void testRemFirstItem()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
			int after = (resultFirstItem == null ? 0: list.size() - 1);
			assertEquals(list.remove(0).getReturnValue(), resultFirstItem);
			assertEquals(after, list.size());
			assertEquals(list.get(0).getReturnValue(), resultSecondItem);
		}
	}
	
	@Test
	public void testRemFourthItem()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int after = (resultFourthItem == null? list.size(): list.size() - 1);
		assertEquals(list.remove(3).getReturnValue(), resultFourthItem);
		assertEquals(after, list.size());
		assertEquals(list.get(3).getReturnValue(), resultFifthItem);	 
		}
	}
	
	@Test
	public void testAddIndexErrorNegativeIndex()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		assertEquals(list.add(-1, "item").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
	}
	
	@Test
	public void testAddIndexErrorUpperBoundIndex()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		assertEquals(list.add(list.size(), "item").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
	}
	
	@Test
	public void testAddItemIndexAtZero()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int after = (resultIsEmpty ? list.size(): list.size() + 1);
		assertEquals(list.add(0, "item").getError(), (resultIsEmpty ? ErrorMessage.INDEX_OUT_OF_BOUNDS : ErrorMessage.NO_ERROR));
		assertEquals(list.get(0).getReturnValue(), (resultIsEmpty ? null : "item"));
		assertEquals(list.get(1).getReturnValue(), resultFirstItem);
		assertEquals(after, list.size());
		}
	}
	
	@Test 
	public void testAddItemIndexAtEnd()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		if (!resultIsEmpty)
		{
		int end = list.size() - 1;
		list.add(end, "item");
		assertEquals(list.get(end).getReturnValue(),"item");
		assertEquals(list.get(end + 1).getReturnValue(), resultLastItem);
		assertEquals(end + 2, list.size());
		}
		}
	}
	
	@Test 
	public void testAddItemIndexAtSecondPoint()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		int size = list.size();
		list.add(1,"item");
		assertEquals(list.get(1).getReturnValue(), ( size <= 1 ? null : "item"));
		assertEquals(list.get(2).getReturnValue(), resultSecondItem);
		assertEquals(list.get(3).getReturnValue(), resultThirdItem);
		assertEquals(list.get(4).getReturnValue(), resultFourthItem);
		assertEquals(list.get(5).getReturnValue(), resultFifthItem);
		}
	}
	
	@Test
	public void testHead()
	{
		for (Object[] test : tests)
		{
		
		assignValues(test);
			
		assertEquals(list.head().getError(), (resultIsEmpty? ErrorMessage.EMPTY_STRUCTURE: ErrorMessage.NO_ERROR));
		assertEquals(list.head().getReturnValue(), resultFirstItem);
		assertEquals(list.size(), resultSize);

		assertEquals(list.get(0).getReturnValue(), resultFirstItem);
		assertEquals(list.get(1).getReturnValue(), resultSecondItem);
		assertEquals(list.get(2).getReturnValue(), resultThirdItem);
		assertEquals(list.get(3).getReturnValue(), resultFourthItem);
		assertEquals(list.get(4).getReturnValue(), resultFifthItem);
		}
	}
	
	@Test
	public void testListNotAlteredByHead()
	{
		FunctionalList testList = new FunctionalLinkedList();
		String[] testArray = new String [] {"original","two"};
		testList.add(testArray);
		String[] newObject = (String[]) testList.head().getReturnValue();
		newObject[0] = "changed";
		assertEquals(((String[])testList.head().getReturnValue())[0], "original");
	}
	
	@Test
	public void testRestReturnEmpty()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		if (list.isEmpty())
		{
			assertTrue(list.rest().isEmpty());	
		}
		}
	}
	
	@Test
	public void testRestValues()
	{
		for (Object[] test : tests)
		{
		assignValues(test);
		FunctionalList restList = list.rest();
		assertEquals(list.get(1).getReturnValue(), restList.get(0).getReturnValue());
		assertEquals(list.get(2).getReturnValue(), restList.get(1).getReturnValue());
		assertEquals(list.get(3).getReturnValue(), restList.get(2).getReturnValue());
		assertEquals(list.get(4).getReturnValue(), restList.get(3).getReturnValue());
		assertNull(restList.get(4).getReturnValue());
		}
	}
	
	@Test 
	public void testRestNotEffectOriginalList()
	{
		FunctionalList testList = new FunctionalLinkedList();
		String[] testArray = new String [] {"original","two"};
		testList.add(1);
		testList.add(testArray);
		testList.add(60);
		FunctionalList restList = testList.rest();
		restList.add(4);
		restList.remove(0);
		assertEquals(testList.get(0).getReturnValue(), resultFirstItem);
		assertEquals(testList.get(0).getReturnValue(), resultSecondItem);
		assertEquals(testList.get(0).getReturnValue(), resultThirdItem);

	}
	
	



}