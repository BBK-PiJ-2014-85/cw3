
package tests;

import cw3.SampleableList;
import cw3.SampleableListImpl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/*
 * Tests the sample methods for the class "SampleableListImpl".
 * 
 * The classes TestSampleableListAsList and TestSampleableListSampleAsList also contribute to the testing
 * of this class by testing the typical "List" methods for both the sampleable list and the list returned by sample().
 * 
 */

public class TestSampleableList {


	SampleableList testList;
	
	@Before
	public void createList()
	{
		testList = new SampleableListImpl();
	}
	
	@Test
	public void testEmpty() {
		SampleableList newList=testList.sample();
		assertTrue(newList.isEmpty());
	}
	
	@Test
	public void  testSample(){

		testList.add(1);
		testList.add(2);
		testList.add(3);
		
		SampleableList listSamp = testList.sample();
		assertEquals(2, listSamp.size());
		assertEquals(1, listSamp.get(0).getReturnValue());
		assertEquals(3, listSamp.get(1).getReturnValue());
	}
	
	@Test
	public void testSampleAfterRemovingEntries(){
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.remove(5);
		testList.remove(4);
		
		SampleableList listSamp = testList.sample();
		
		assertEquals(2, listSamp.size());
		assertEquals(1, listSamp.get(0).getReturnValue());
		assertEquals(3, listSamp.get(1).getReturnValue());
		
	}
	
	@Test
	public void testOriginalListUnalteredByRemovingFromSampled(){
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		
		SampleableList listSample = testList.sample();
		listSample.remove(0);

		assertEquals(7, testList.size());
		assertEquals(1, testList.get(0).getReturnValue());
		assertEquals(2, testList.get(1).getReturnValue());
		assertEquals(3, testList.get(2).getReturnValue());
		assertEquals(4, testList.get(3).getReturnValue());
		assertEquals(5, testList.get(4).getReturnValue());
		assertEquals(6, testList.get(5).getReturnValue());
		assertEquals(7, testList.get(6).getReturnValue());
	}

}
