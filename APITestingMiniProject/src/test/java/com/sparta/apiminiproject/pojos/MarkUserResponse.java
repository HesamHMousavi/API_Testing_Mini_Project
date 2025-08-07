package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarkUserResponse {

	@JsonProperty("user")
	private MarkUser user;

	@JsonProperty("responseCode")
	private int responseCode;

	public MarkUser getUser(){
		return user;
	}

	public int getResponseCode(){
		return responseCode;
	}
}