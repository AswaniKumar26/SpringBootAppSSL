package com.learning.ws.exception;

public class CustomServiceException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -683261942491152249L;

	public CustomServiceException(String Message) {
    	super(Message);
    }
}
