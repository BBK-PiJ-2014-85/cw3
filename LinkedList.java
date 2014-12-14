
public class LinkedList implements List {

	LinkedList next;
	Object value;
	
	@Override
	public boolean isEmpty() {
		if (value == null) return true;
		return false;
	}

	@Override
	public int size() {
		if (next == null && value==null) return 0;
		if (next == null) return 1;
		return 1 + next.size();
	}

	@Override
	public ReturnObject get(int index) {
		
		if (testBounds(index).hasError()) return testBounds(index);
		
		if (index == 0) return new ReturnObjectImpl(value);
		return next.get(index - 1);
	}

	@Override
	public ReturnObject remove(int index) {
		
		if (testBounds(index).hasError()) return testBounds(index);
		
		if (index == 0) 
		{
			ReturnObject deletedItem = new ReturnObjectImpl(value);
			moveValuesForward();
			return deletedItem;
		}
		
		return next.remove(index - 1);
	}

	private void moveValuesForward()
	{
		if (next!=null)
		{
			value = next.getValue();
			if (next.next == null) next = null;
			else next.moveValuesForward();
		}
		else
		{
			value = null;
		}
	}
	
	private ReturnObject testBounds(int index)
	{
		if (next == null && value==null) {return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);}
		if (index < 0) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		if (next == null && index !=0) { return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);}
		return new ReturnObjectImpl();
	}
	
	private Object getValue() {return value;}
	
	@Override
	public ReturnObject add(int index, Object item) {
		

		if (testBounds(index).hasError()) return testBounds(index);
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (index == 0)
		{
			LinkedList temp = new LinkedList();
			temp.setValue(value);
			temp.setNext(next);
			value = item;
			next = temp;
			return new ReturnObjectImpl();
		}
		
		return next.add(index - 1, item);
	}
	
	private void setValue(Object item) {value = item;}
	private void setNext(LinkedList nextItem) {next = nextItem;}
	
	@Override
	public ReturnObject add(Object item) {
	
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		if (value == null) 
		{
			value = item;
			return new ReturnObjectImpl();
		}
		
		if (next == null) {next = new LinkedList();}
		
		return next.add(item);
	}

}
