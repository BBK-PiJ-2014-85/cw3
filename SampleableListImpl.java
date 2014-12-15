
public class SampleableListImpl extends ArrayList implements SampleableList {


	@Override
	public SampleableList sample() {

		SampleableList listSample = new SampleableListImpl();
		
		int i=0;
		while (!get(i).hasError())
		{
			listSample.add(get(i).getReturnValue());
			i += 2;
		}
		
		return listSample;
	}

}
