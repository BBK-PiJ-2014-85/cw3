
public class ArrayList implements List {

	private Object[] list = new Object[4];
	//TODO: Decide on a more sensible size for the array
	
	@Override
	public boolean isEmpty() {
		
		if (list[0] == null) return true;
		return false;
	}

	@Override
	public int size() {

		if (isEmpty()) return 0;
		
		int i=0;
		while (list[i] != null) i++;
		return i+1;
	}

	@Override
	public ReturnObject get(int index) {

		return null;
	}

	@Override
	public ReturnObject remove(int index) {

		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		
		//TODO: If its requested to be added at a point after all others, do we add it at end, or return error (or extend off?)
		//		for example add(10, item) for a list only containing 8 items, what do we do?
		
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
	
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (list.length == size() + 1) extendArray();

		list[size()] = item;
		
		return new ReturnObjectImpl(list);
	}
	
	private void extendArray()
	{
		Object[] newList = new Object[list.length * 2];
		
		for (int i=0; i<list.length; i++) {newList[i] = list[i];}
		
		list = newList;
	}

}
