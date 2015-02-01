
package tests;

import interfaces.List;
import cw3.LinkedList;

/**
 * This class tests the LinkedList implementation of List by extending the TestList test class.
 * 
 * @author Paul Day
 */

public class TestLinkedList extends TestList{

	public TestLinkedList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new LinkedList();
	}

}