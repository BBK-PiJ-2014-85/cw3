
public class test {

	public static void main(String[] args)
	{
		testReturnObject();
		
		List al = new ArrayList();
		testList(al);
				
		
		
		
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
		if (list.remove(0).getError() != ErrorMessage.EMPTY_STRUCTURE) System.out.println("Error not returning on empty structure " + list.remove(0).getError().toString()); //this should provide a zero entry error
		
		if (list.add(null).getError() != ErrorMessage.INVALID_ARGUMENT) System.out.println("Error allowing null input");

	}
}
