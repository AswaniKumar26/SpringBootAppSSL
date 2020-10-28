package com.learning.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.ws.model.ApplicationException;
@ControllerAdvice
public class ApplicationExceptions extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest wr){
		
		// To return exception as is 
		//return new ResponseEntity<>(e,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		// Throwing Custom exception
		String errMsg = e.getLocalizedMessage();
		if(errMsg == null) {
			errMsg = e.toString();
		}
		ApplicationException ae = new ApplicationException(new Date(),errMsg);
		return new ResponseEntity<>(ae,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Handling a Specific Exception (NullPouinterException.
	@ExceptionHandler(value= {NullPointerException.class,
			                  CustomServiceException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception e, WebRequest wr){
		
		// To return exception as is 
		//return new ResponseEntity<>(e,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		// Throwing Custom exception
		String errMsg = e.getLocalizedMessage();
		if(errMsg == null) {
			errMsg = e.toString();
		}
		ApplicationException ae = new ApplicationException(new Date(),errMsg);
		return new ResponseEntity<>(ae,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
