
package tests;

import interfaces.List;
import cw3.FunctionalLinkedList;

/**
 * This class tests the FunctionalLinkedList implementation of FunctionalList by extending the TestFunctionalList test class.
 * 
 * @author Paul Day
 */

public class TestFunctionalLinkedList extends TestFunctionalList{
	
	public TestFunctionalLinkedList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new FunctionalLinkedList();
	}

}