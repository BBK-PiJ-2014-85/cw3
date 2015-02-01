package tests;

import interfaces.List;
import cw3.SampleableListImpl;

/**
 * Class tests the List methods of SampleableListImpl implementing SampleableList.
 * 
 * @author Paul Day
 *
 */

public class TestSampleableListAsList extends TestList{

	public TestSampleableListAsList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new SampleableListImpl();
	}

}
