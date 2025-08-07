package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarkUser {

	@JsonProperty("country")
	private String country;

	@JsonProperty("address2")
	private String address2;

	@JsonProperty("city")
	private String city;

	@JsonProperty("birth_month")
	private String birthMonth;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("title")
	private String title;

	@JsonProperty("birth_year")
	private String birthYear;

	@JsonProperty("birth_day")
	private String birthDay;

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("name")
	private String name;

	@JsonProperty("company")
	private String company;

	@JsonProperty("id")
	private int id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("email")
	private String email;

	public MarkUser() {
		
	}
	// Constructor excluding email
	public MarkUser(String country, String address2, String city, String birthMonth, String address1,
					String lastName, String title, String birthYear, String birthDay, String zipcode,
					String name, String company, int id, String state, String firstName) {
		this.country = country;
		this.address2 = address2;
		this.city = city;
		this.birthMonth = birthMonth;
		this.address1 = address1;
		this.lastName = lastName;
		this.title = title;
		this.birthYear = birthYear;
		this.birthDay = birthDay;
		this.zipcode = zipcode;
		this.name = name;
		this.company = company;
		this.id = id;
		this.state = state;
		this.firstName = firstName;
	}

	// Getters and setters (email setter included)
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }

	public String getAddress2() { return address2; }
	public void setAddress2(String address2) { this.address2 = address2; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public String getBirthMonth() { return birthMonth; }
	public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }

	public String getAddress1() { return address1; }
	public void setAddress1(String address1) { this.address1 = address1; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getBirthYear() { return birthYear; }
	public void setBirthYear(String birthYear) { this.birthYear = birthYear; }

	public String getBirthDay() { return birthDay; }
	public void setBirthDay(String birthDay) { this.birthDay = birthDay; }

	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getState() { return state; }
	public void setState(String state) { this.state = state; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}