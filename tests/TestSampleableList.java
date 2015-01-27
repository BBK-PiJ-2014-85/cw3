
package tests;

import cw3.SampleableList;
import cw3.SampleableListImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TestSampleableList {


	SampleableList testList = new SampleableListImpl();
	
	
	@Test
	public void testEmpty() {
		SampleableList emptyList = new SampleableListImpl();
		SampleableList newList=emptyList.sample();
		assertTrue(newList.isEmpty());
	}
	
	@Test
	public void  testSample(){

		SampleableList list3 = new SampleableListImpl();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		
		SampleableList list3samp = list3.sample();
		assertEquals(list3samp.size(), 2);
		assertEquals(list3samp.get(0).getReturnValue(), 1);
		assertEquals(list3samp.get(1).getReturnValue(), 3);
		
		SampleableList list4 = new SampleableListImpl();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		
		SampleableList list4samp = list4.sample();
		assertEquals(list4samp.size(), 2);
		assertEquals(list4samp.get(0).getReturnValue(), 1);
		assertEquals(list4samp.get(1).getReturnValue(), 3);
	}
	
	@Test
	public void testOriginalListUnaltered(){
		SampleableList list = new SampleableListImpl();
		list.add(new String[] {"original","second"});
		SampleableList listSample = list.sample();
		String[] items = (String[]) listSample.get(0).getReturnValue();
		items[0]="changed";
		assertEquals(((String []) list.get(0).getReturnValue())[0], "original");
	}

}
