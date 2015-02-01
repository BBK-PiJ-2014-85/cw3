
package cw3;

import interfaces.ReturnObject;
import interfaces.ErrorMessage;

/**
 * A implementation of RetyurnObject.
 * 
 * @author Paul Day
 */

public class ReturnObjectImpl implements ReturnObject {

	private ErrorMessage errorMsg;
	private Object rtnObj;
	
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
		return errorMsg;
	}

	@Override
	public Object getReturnValue() {
		if (hasError()) return null;
		return rtnObj;
	}

}
