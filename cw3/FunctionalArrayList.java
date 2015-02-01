
package cw3;

import interfaces.ErrorMessage;
import interfaces.FunctionalList;
import interfaces.ReturnObject;


/**
 * An implementation of FunctionalList using an ArrayList structure for the underlying list
 * 
 * @author Paul Day
 */

public class FunctionalArrayList extends ArrayList implements FunctionalList {

	@Override
	public ReturnObject head() {
		
		if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		return new ReturnObjectImpl(get(0).getReturnValue());
	}

	@Override
	public FunctionalList rest() {
		
		FunctionalList rest = new FunctionalArrayList();
		
		int i = 1;
		while(!get(i).hasError()) //error occurs once out of bounds
		{
			rest.add(get(i).getReturnValue());
			i++;
		}
		
		return rest;
	}
}
