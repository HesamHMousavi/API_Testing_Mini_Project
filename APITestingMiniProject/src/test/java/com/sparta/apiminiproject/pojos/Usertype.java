package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usertype{

	@JsonProperty("usertype")
	private String usertype;

	public String getUsertype(){
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}