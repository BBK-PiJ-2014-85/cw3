
package cw3;

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
