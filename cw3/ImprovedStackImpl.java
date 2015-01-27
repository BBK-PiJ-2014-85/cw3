
package cw3;

public class ImprovedStackImpl implements ImprovedStack {

	Stack internalStack = new StackImpl(new ArrayList());
	
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
		
		Stack rebuiltInternalStack = new StackImpl(new ArrayList());
		int size = internalStack.size();
		Object[] items = new Object[size];
		//TODO: Check reverse shouldn't delete the original stack, which just popping it off would. I therefore record values in an array and rebuild the internal stack afterwards
		
		int c = 0;
		while (!internalStack.top().hasError())
		{
			items[c] = internalStack.pop().getReturnValue();
			c++;
		}
		
		for (int i = 0; i < size; i++)
		{
			reversedStack.push(items[i]);
			rebuiltInternalStack.push(items[size - 1 - i]);
		}
			
		internalStack = rebuiltInternalStack;
		
		return reversedStack;
	}

	@Override
	public void remove(Object object) {

		ImprovedStackImpl reversedValidStack = new ImprovedStackImpl();
		
		while (!internalStack.top().hasError()) 
		{
			if (!internalStack.top().getReturnValue().equals(object)) reversedValidStack.push(internalStack.pop().getReturnValue());
		}
		
		internalStack = reversedValidStack.reverse();
	}

}
