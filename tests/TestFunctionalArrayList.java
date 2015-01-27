
package tests;

import cw3.List;
import cw3.FunctionalArrayList;

public class TestFunctionalArrayList extends TestFunctionalList{

	/*
	 * Extended class TestFunctionalList provides all the parameters and tests to be tested (via extension of the TestList class).
	 * 
	 * CreateList() as defined below ensures the tests being tested are as created by the class "FunctionalArrayList".
	 */
	
	public TestFunctionalArrayList(int index, String name) {
		super(index, name);	
	}

	@Override
	public List createStartingList() {
		return new FunctionalArrayList();
	}

}