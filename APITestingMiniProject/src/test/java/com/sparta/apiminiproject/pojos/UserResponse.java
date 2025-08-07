package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	@JsonProperty("user")
	private User user;

	@JsonProperty("responseCode")
	private int responseCode;

	public User getUser(){
		return user;
	}

	public int getResponseCode(){
		return responseCode;
	}
}