
package tests;

import cw3.List;
import cw3.LinkedList;

public class TestLinkedList extends TestList{

	/*
	 * Extended class TestList contains all the parameters and tests to be tested.
	 * 
	 * CreateList() as defined below ensures the tests being tested are as created by the class "LinkedList".
	 */
	
	public TestLinkedList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new LinkedList();
	}

}