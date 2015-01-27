
public class ReturnObjectImpl implements ReturnObject {

	private ErrorMessage errorMsg;
	private Object rtnObj;
	
	/* It is possible in theory to create a return object with error message "no_error" but without an 
	 * object via running the constructor with a no_error error message only. However, resolving this would involve
	 * creating another specific error message for this, and the code using this class would never want to create this 
	 * either, and so this has not been addressed within this class as the error would be with the class running this. 
	 */

	
	public ReturnObjectImpl(ErrorMessage error)
	{
		errorMsg = error;
	}
	
	public ReturnObjectImpl(Object item)
	{
		rtnObj = item;
		errorMsg = ErrorMessage.NO_ERROR;
	}
	
	public ReturnObjectImpl() //TODO: Do I need this constructor? Seems unlikely to be useful.
	{
		errorMsg = ErrorMessage.NO_ERROR;
	}
	
	@Override
	public boolean hasError() {
		if (errorMsg == ErrorMessage.NO_ERROR) return false;
		return true;
	}

	@Override
	public ErrorMessage getError() {
		return errorMsg;
	}

	@Override
	public Object getReturnValue() {
		if (hasError()) return null;
		return rtnObj;
	}

}
