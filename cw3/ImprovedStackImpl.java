
package cw3;

import interfaces.ImprovedStack;
import interfaces.ReturnObject;
import interfaces.Stack;

/**
 * An implementation of ImprovedStack. 
 * 
 * @author Paul Day
 *
 */

public class ImprovedStackImpl implements ImprovedStack {

	Stack internalStack = new StackImpl();
	
	@Override
	public boolean isEmpty() {
		return internalStack.isEmpty();
	}

	@Override
	public int size() {
		return internalStack.size();
	}

	@Override
	public void push(Object item) {	
		internalStack.push(item);
	}

	@Override
	public ReturnObject top() {
		return internalStack.top();
	}

	@Override
	public ReturnObject pop() {
		return internalStack.pop();
	}

	@Override
	public ImprovedStack reverse() {
		
		ImprovedStack reversedStack = new ImprovedStackImpl();
		
		if (internalStack.isEmpty()) return reversedStack;
		
		Stack rebuiltInternalStack = new StackImpl();
		
		int size = internalStack.size();
		
		Object[] items = new Object[size];
		
		int c = 0;
		while (!internalStack.top().hasError()) //take all items out of current stack and store in an array
		{
			items[c] = internalStack.pop().getReturnValue();
			c++;
		}
		
		for (int i = 0; i < size; i++)
		{
			reversedStack.push(items[i]); //add items to reverse stack in the order they came out original stack
			rebuiltInternalStack.push(items[size - 1 - i]); //add items to the internal stack in the opposite order they came out to rebuild internal stack
		}
			
		internalStack = rebuiltInternalStack;
		
		return reversedStack;
	}

	@Override
	public void remove(Object object) {

		ImprovedStackImpl reversedValidStack = new ImprovedStackImpl();
		
		while (internalStack.size() != 0) 
		{
			if (!internalStack.top().getReturnValue().equals(object)) //if the top value isn't to be removed ...
			{
				reversedValidStack.push(internalStack.top().getReturnValue()); //... store it in the temporary stack to be kept
			}
			internalStack.pop();
		}
		
		/*Add elements to be kept back in the original stack. While using reversedValidStack.reverse() would have the same effect,
		  it would be less efficient as it would also maintain "reversedValidStack", which is not required */
		while (reversedValidStack.size() != 0) internalStack.push(reversedValidStack.pop().getReturnValue());
		
	}

}
