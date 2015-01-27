
package tests;

import cw3.ReturnObject;
import cw3.ReturnObjectImpl;
import cw3.ErrorMessage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;



public class TestReturnObject {

	private ReturnObject string;
	private ReturnObject integer;
	private ReturnObject rtnObj;
	private ReturnObject array;
	private ReturnObject noError;
	private ReturnObject emptyStructure;
	private ReturnObject indexOOB;
	private ReturnObject invalidArg;
	
	private Object[] testArray;
	private ReturnObject testRtnObj;
	
	@Before
	public void setUpObjects() {
		
		testArray = new Object[] {"Test",7.3};
		testRtnObj = new ReturnObjectImpl("Return object");
		
		string= new ReturnObjectImpl("Word");
		integer= new ReturnObjectImpl(7);
		rtnObj= new ReturnObjectImpl(testRtnObj);
		array= new ReturnObjectImpl(testArray);
		noError= new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		emptyStructure = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		indexOOB= new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		invalidArg= new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
	}
	
	@Test
	public void testIsErrorOnNoError() {
		
		assertFalse(string.hasError());
		assertFalse(integer.hasError());
		assertFalse(array.hasError());
		assertFalse(rtnObj.hasError());
		assertFalse(noError.hasError());
	}
	
	@Test
	public void testAddingAndRetreivingObject() {
		assertEquals(string.getReturnValue(), "Word");
		assertEquals(integer.getReturnValue(), 7);
		assertEquals(array.getReturnValue(), testArray);
		assertEquals(rtnObj.getReturnValue(), testRtnObj);
		assertNull(noError.getReturnValue());
	}

	@Test
	public void testErrorIsNoErrorWhenAddingObject() {
		assertEquals(string.getError(), ErrorMessage.NO_ERROR);
		assertEquals(integer.getError(), ErrorMessage.NO_ERROR);
		assertEquals(array.getError(), ErrorMessage.NO_ERROR);
		assertEquals(rtnObj.getError(), ErrorMessage.NO_ERROR);
		assertEquals(noError.getError(), ErrorMessage.NO_ERROR);
	}


	@Test
	public void testIsErrorWhenError() {
		
		assertTrue(emptyStructure.hasError());
		assertTrue(indexOOB.hasError());
		assertTrue(invalidArg.hasError());
		
	}
	
	@Test
	public void testErrorMessageReturnsSame() {
		assertEquals(emptyStructure.getError(), ErrorMessage.EMPTY_STRUCTURE);
		assertEquals(indexOOB.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		assertEquals(invalidArg.getError(), ErrorMessage.INVALID_ARGUMENT);
	}
	
	@Test
	public void testReturnNullOnError() {
		assertNull(emptyStructure.getReturnValue());
		assertNull(indexOOB.getReturnValue());
		assertNull(invalidArg.getReturnValue());
	}
	

	

	
	

}
