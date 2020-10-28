package com.learning.ws.model.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRecordRequest {
	private String id;
	@NotNull(message="fullName Cannot be Null")
	@NotBlank
	@Size(min=4,max=20, message="fullName size should be minimum of 4 charectres and maximum of 20 charecters")
	private String fullName;
	
	@NotNull(message="email Cannot be Null")
	@Email
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
