package com.learning.ws.model;

import java.util.Date;

public class ApplicationException {
	private Date date;
	private String errorDetails;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	public ApplicationException() {
	}
	public ApplicationException(Date date, String errorDetails) {
		this.date = date;
		this.errorDetails = errorDetails;
	}
	

}
