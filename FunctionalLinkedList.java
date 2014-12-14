
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	@Override
	public ReturnObject head() {
		
		if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		return new ReturnObjectImpl(get(0).getReturnValue());
	}

	@Override
	public FunctionalList rest() {
		
		FunctionalList rest = new FunctionalLinkedList();
		
		int i = 1;
		while(!get(i).hasError())
		{
			rest.add(get(i).getReturnValue());
			i++;
		}
		
		return rest;
	}
}
