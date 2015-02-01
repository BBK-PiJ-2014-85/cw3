
package tests;

import interfaces.List;
import cw3.ArrayList;

/**
 * This class tests the ArrayList implementation of List by extending the TestList test class.
 * 
 * @author Paul Day
 */

public class TestArrayList extends TestList{

	public TestArrayList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new ArrayList();
	}

}