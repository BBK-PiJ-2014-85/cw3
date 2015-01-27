
package tests;

import cw3.List;
import cw3.ArrayList;

public class TestArrayList extends TestList{

	/*
	 * Extended class TestList contains all the parameters and tests to be tested.
	 * 
	 * CreateList() as defined below ensures the tests being tested are as created by the class "ArrayList".
	 */

	public TestArrayList(int index, String name) {
		super(index, name);
	}

	@Override
	public List createStartingList() {
		return new ArrayList();
	}

}