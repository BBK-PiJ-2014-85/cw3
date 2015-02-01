
package cw3;

import interfaces.List;
import interfaces.ReturnObject;
import interfaces.ErrorMessage;

/**
 * An implementation of List using Arrays.
 * 
 * @author Paul Day
 */

public class ArrayList implements List {

	private static final int STARTING_ARRAY_SIZE = 4;
	
	private Object[] list = new Object[STARTING_ARRAY_SIZE];
	private int size = 0;
	
	@Override
	public boolean isEmpty() {
		
		if (list[0] == null) return true;
		return false;
	}

	@Override
	public int size() {return size;}

	@Override
	public ReturnObject get(int index) {

		if (testBound(index).hasError()) return testBound(index);
		
		return new ReturnObjectImpl(list[index]);
	}

	@Override
	public ReturnObject remove(int index) {

		if (testBound(index).hasError()) return testBound(index);
		
		ReturnObject rtnItem = new ReturnObjectImpl(list[index]);
		list[index] = null;
		
		while (list[index + 1] != null) //Moves all elements in the array after that just removed forward 1 in the array
		{
			list[index] = list[index + 1];
			list[index+1] = null;
			index++;
		}
		
		size--;
		
		return rtnItem;
	}

	@Override
	public ReturnObject add(int index, Object item) {
				
		if (testBound(index).hasError()) return testBound(index);
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (list.length == size() + 1) extendArray();
		
		for (int i = size() - 1; i >= index ; i--) { list[i+1] = list[i]; } //Move all items in list back one after where the object needs to be inserted
		
		list[index] = item;
		
		size++;
		
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	/**
	 * Tests if the index of the list is within the bounds of the list. Negative indexes, or those too high return an error message.
	 * 
	 * @param index the location of the list to check (first element is 0)
	 * @return an appropriate error message if the list is empty or the index is out of bounds, or no error otherwise, encapsulated within a ReturnObject
	 */
	
	private ReturnObject testBound(int index)
	{
		if (size() == 0) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		if (index + 1 > size() || index < 0) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	@Override
	public ReturnObject add(Object item) {
	
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (list.length == size() + 1) extendArray();

		list[size()] = item;
		
		size++;
		
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	/**
	 * Extends the array holding the list by doubling its length and copying over the elements already in the list into the same position.
	 */
	
	private void extendArray()
	{
		Object[] newList = new Object[list.length * 2];
		
		for (int i=0; i<list.length; i++) {newList[i] = list[i];}
		
		list = newList;
	}

}
