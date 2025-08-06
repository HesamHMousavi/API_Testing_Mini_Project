package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse{

	@JsonProperty("message")
	private String message;

	@JsonProperty("responseCode")
	private int responseCode;

	public String getMessage(){
		return message;
	}

	public int getResponseCode(){
		return responseCode;
	}
}