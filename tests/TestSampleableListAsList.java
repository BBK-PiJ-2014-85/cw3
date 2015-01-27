package tests;

import cw3.List;
import cw3.SampleableListImpl;

public class TestSampleableListAsList extends TestList{
	
	/*
	 * Extended class TestList contains all the parameters and tests to be tested.
	 * 
	 * CreateList() as defined below ensures tests are testing the List method classes for class "SampleableListImpl".
	 */

	public TestSampleableListAsList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new SampleableListImpl();
	}

}
