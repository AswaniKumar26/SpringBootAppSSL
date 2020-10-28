package com.learning.ws.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UpdateRequest {
	@Size(min=4,max=20,message="Mimimun size should be 2 and Maximum size should be 20")
	private String fullName;
	@Email
	private String email;
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
