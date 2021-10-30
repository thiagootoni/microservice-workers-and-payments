package com.thiago.hroauth.dtos;

import java.io.Serializable;

public class UserFetchedDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;

	public UserFetchedDto() {
	}

	public UserFetchedDto(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}