package tests;

import cw3.List;
import cw3.SampleableList;
import cw3.SampleableListImpl;

public class TestSampleableListSampleAsList extends TestList{

	/*
	 * Extended class TestList contains all the parameters and tests to be tested.
	 * 
	 * CreateList() as defined below ensures tests are testing the List method classes for returned "SampleableList" returned 
	 * when sampling "SampleableListImpl".
	 */
	
	public TestSampleableListSampleAsList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		SampleableList newList = new SampleableListImpl();
		return newList.sample();
	}

}
