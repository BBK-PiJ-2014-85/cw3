package tests;
/*
import default;

public class test {

	public static void main(String[] args)
	{
		testReturnObject();
		
		List al = new ArrayList();
		testList(al);
				
		List ll = new LinkedList();
		testList(ll);
		
		FunctionalList fal = new FunctionalArrayList();
		testFunctionalList(fal);
		
		FunctionalList fll = new FunctionalLinkedList();
		testFunctionalList(fll);
		
		SampleableList sl = new SampleableListImpl();
		testSampleableList(sl);
		
		Stack stack = new StackImpl(new ArrayList());
		testStack(stack);
		stack = new StackImpl(new LinkedList());
		testStack(stack);
	}
	
	private static void testReturnObject()
	{
		ReturnObject ro = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		if (ro.getReturnValue() != null || !ro.hasError()) System.out.println("Value not null on error creating.");
		ro = new ReturnObjectImpl("test");
		if (!ro.getReturnValue().equals("test")) System.out.println("Value not held correctly.");
		if (ro.hasError() || ro.getError() != ErrorMessage.NO_ERROR) System.out.println("Errors erroneously held when setting value");
	}
	
	private static void testList(List list)
	{

		//add 5 items to make sure expand works
		//System.out.println(list.add("word").getError()); //TODO: test point add(0,item)
		if (list.add("word").hasError()) System.out.println("Error in add 1");
		if (list.add(list).getError() != ErrorMessage.NO_ERROR) System.out.println("Error in add 2");
		list.add(3);
		list.add(2);
		list.add(4.567);
		if(!list.get(3).getReturnValue().toString().equals("2")) System.out.println("Error in add test " + list.get(3).getReturnValue().toString() );

		
		//delete an item that is in list
		list.remove(3);
		if (!list.get(3).getReturnValue().toString().equals("4.567")) System.out.println("Error in remove test 1 " + list.get(3).getReturnValue().toString());
		if (list.get(4).getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS) System.out.println("Error measuring out of bounds " + list.get(4).getError() + " " + list.get(4).getReturnValue().toString());
		
		list.add(3,"test");
		if (!list.get(3).getReturnValue().toString().equals("test")) System.out.println("Error adding with index");
		if (!list.get(4).getReturnValue().toString().equals("4.567")) System.out.println("Error increasing indexes when adding");
		list.add(0,1);
		if (!list.get(1).getReturnValue().toString().equals("word")) System.out.println("Error adding to 0");
		
		if (list.get(-1).getError() != ErrorMessage.INDEX_OUT_OF_BOUNDS) System.out.println("Error referencing negative index");
		
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		if (!list.isEmpty()) System.out.println("Error with isEmpty()");
		if (list.remove(0).getError() != ErrorMessage.EMPTY_STRUCTURE) System.out.println("Error not returning on empty structure " + list.remove(0).getError().toString()); //this should provide a zero entry error
		
		if (list.add(null).getError() != ErrorMessage.INVALID_ARGUMENT) System.out.println("Error allowing null input");
		list.add(3);
		if (list.add(0,null).getError() != ErrorMessage.INVALID_ARGUMENT) System.out.println("Error allowing null input");

		list.get(4).getReturnValue();
		
	}
	
	private static void testFunctionalList(FunctionalList list)
	{
		if(!list.head().hasError()) System.out.println("Functional list: hasError not correctly returned for head");
		if(list.head().getError() != ErrorMessage.EMPTY_STRUCTURE) System.out.println("Functional list: Error not correctly returned for head");
		if(!list.rest().isEmpty()) System.out.println("Functional List: Empty list not returned from rest() for an empty list");
		list.add(1);
		if(!list.rest().isEmpty()) System.out.println("Functional List: Empty list not returned from rest() for a list with one item");
		if(!list.head().getReturnValue().toString().equals("1")) System.out.println("Functional List: head() not returned properly for lists with 1 item");	
		list.add(2);
		list.add(3);
		if(!list.head().getReturnValue().toString().equals("1")) System.out.println("Functional List: head() not returned properly for lists with 1 item");
		if(list.rest().size() != 2) System.out.println("Functional List: rest not returned properly for lists with 3 items");
		if(!list.rest().get(0).getReturnValue().toString().equals("2")) System.out.println("Functional List: rest() not returned first entry properly lists with 3 items");
		if(!list.rest().get(1).getReturnValue().toString().equals("3")) System.out.println("Functional List: rest() not returned second entry propoerly lists with 3 items");	
	}
	
	private static void testSampleableList(SampleableList list)
	{
		if(list.sample().size() != 0) System.out.println("Sampleable List: Empty list not returned correctly");
		list.add(1);
		list.add(2);
		if(list.sample().size() != 1 || !list.sample().get(0).getReturnValue().toString().equals("1")) System.out.println("Sampleable List: List of 1 not correctly returned");
		list.add(3);
		list.add(4);
		if(list.sample().size() != 2 || !list.sample().get(0).getReturnValue().toString().equals("1") || !list.sample().get(1).getReturnValue().toString().equals("3")) 
		{
			System.out.println("Sampleable List: List of 2 not correctly returned");
		}
	}
	
	private static void testStack(Stack stack)
	{
		if (!stack.isEmpty()) System.out.println("Stack: Error with isEmpty()");
		if (!stack.top().hasError() || stack.top().getError() != ErrorMessage.EMPTY_STRUCTURE) System.out.println("Stack: Error for empty stack when using top() not treated properly");
		if (!stack.pop().hasError() || stack.top().getError() != ErrorMessage.EMPTY_STRUCTURE) System.out.println("Stack: Error for empty stack when using pop() not treated properly");
		stack.push(1);
		stack.push(2);
		if(stack.size() != 2 || !stack.top().getReturnValue().toString().equals("2")) System.out.println("Stack: Error with stack of two items");
		if(stack.size() != 2 || !stack.top().getReturnValue().toString().equals("2")) System.out.println("Stack: Error with top() changing stack");
		stack.push(null); // This checks this doesn't fall over or add anything. Given that push() doesn't return anything an error code cannot be returned.
		if(stack.size() != 2 || !stack.top().getReturnValue().toString().equals("2")) System.out.println("Stack: Error with nulls entering stack");
		stack.pop();
		if(stack.size() != 1 || !stack.top().getReturnValue().toString().equals("1")) System.out.println("Stack: Error with pop()");
		
	}
	
	private static void testImprovedStack(ImprovedStack stack)
	{
		testStack(stack);
		
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		
		
		
	}
}
*/