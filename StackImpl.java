
public class StackImpl extends AbstractStack{

	public StackImpl(List list) {
		super(list);
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
		//TODO: check if add(index,item) should be changed to allow adding to an empty list, which if so would make the code below slightly easier
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
