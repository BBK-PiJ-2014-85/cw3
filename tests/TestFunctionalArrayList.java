
package tests;

import interfaces.List;
import cw3.FunctionalArrayList;

/**
 * This class tests the FunctionalArrayList implementation of FunctionalList by extending the TestFunctionalList test class.
 * 
 * @author Paul Day
 */

public class TestFunctionalArrayList extends TestFunctionalList{


	public TestFunctionalArrayList(int index, String name) {
		super(index, name);	
	}

	@Override
	public List createStartingList() {
		return new FunctionalArrayList();
	}

}