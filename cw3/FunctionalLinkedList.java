
package cw3;

import interfaces.ErrorMessage;
import interfaces.FunctionalList;
import interfaces.ReturnObject;

/**
 * An implementation of FunctionalList using an underlying list using pointers.
 * 
 * @author Paul Day
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	@Override
	public ReturnObject head() {
		
		if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		return new ReturnObjectImpl(get(0).getReturnValue());
	}
	
	@Override
	public FunctionalList rest() {
		
		FunctionalList rest = new FunctionalLinkedList();
		
		LinkedList nextItem = next;
		
		while(nextItem != null)
		{
			rest.add(nextItem.value);
			nextItem = nextItem.next;
		}
		
		return rest;
	}
}
