
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
		return i;
	}

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
		
		while (list[index + 1] != null)
		{
			list[index] = list[index + 1];
			index++;
		}
		
		return rtnItem;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		
		if (testBound(index).hasError()) return testBound(index);
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (list.length == size() + 1) extendArray();
		
		for (int i = size() - 1; i >= index ; i--) { list[i+1] = list[i]; }
		
		list[index] = item;
		
		return new ReturnObjectImpl();
	}
	
	private ReturnObject testBound(int index)
	{
		if (size() == 0) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); //TODO: Doesn't explicitly say this is required so consider this further
		if (index + 1 > size()) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		return new ReturnObjectImpl();
	}

	@Override
	public ReturnObject add(Object item) {
	
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (list.length == size() + 1) extendArray();

		list[size()] = item;
		
		//TODO: This needs to be set to return empty returnObject - currently returning one with just a ErrorMessage.NO_ERROR, defined by an empty constructor
		return new ReturnObjectImpl();
	}
	
	private void extendArray()
	{
		Object[] newList = new Object[list.length * 2];
		
		for (int i=0; i<list.length; i++) {newList[i] = list[i];}
		
		list = newList;
	}

}
