package tests;

import interfaces.List;
import interfaces.SampleableList;
import cw3.SampleableListImpl;

/**
 * Class tests the List methods of a SampleableListImpl provided as output by a sample() method on a SampleableListImpl implementing SampleableList.
 * 
 * @author Paul Day
 *
 */

public class TestSampleableListSampleAsList extends TestList{
	
	public TestSampleableListSampleAsList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		SampleableList newList = new SampleableListImpl();
		return newList.sample();
	}

}
