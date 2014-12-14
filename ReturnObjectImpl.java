
public class ReturnObjectImpl implements ReturnObject {

	ErrorMessage errorMsg;
	Object rtnObj;
	
	public ReturnObjectImpl(ErrorMessage error)
	{
		errorMsg = error;
	}
	
	public ReturnObjectImpl(Object item)
	{
		rtnObj = item;
		errorMsg = ErrorMessage.NO_ERROR;
	}
	
	@Override
	public boolean hasError() {
		if (errorMsg == ErrorMessage.NO_ERROR) return false;
		return true;
	}

	@Override
	public ErrorMessage getError() {
		//TODO: Currently not sure why would need anything more in here
		return errorMsg;
	}

	@Override
	public Object getReturnValue() {
		if (hasError()) return null;
		return rtnObj;
	}

}
