
package cw3;

import interfaces.AbstractStack;
import interfaces.ReturnObject;

/**
 * A class with basic stack methods as defined by AbstractStack.
 * 
 * @author Paul Day
 */

public class StackImpl extends AbstractStack{

	public StackImpl() {
		super(new ArrayList()); //CW doesn't state that list type should be selectable, and as it makes no difference to user it is set to an ArrayList
	}

	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public int size() {
		return internalList.size();
	}

	@Override
	public void push(Object item) {
		//CW spec says null item does not need to be dealt with, and therefore no checks are made here
		if (internalList.isEmpty()) internalList.add(item);
		else internalList.add(0,item);	
	}

	@Override
	public ReturnObject top() {
		return internalList.get(0);
	}

	@Override
	public ReturnObject pop() {
		return internalList.remove(0);
	}

}
