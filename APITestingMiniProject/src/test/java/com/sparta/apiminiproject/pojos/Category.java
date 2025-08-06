package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("usertype")
    private Usertype usertype;

    @JsonProperty("category")
    private String category;

    // Getters & Setters
    public Usertype getUsertype() { return usertype; }
    public void setUsertype(Usertype usertype) { this.usertype = usertype; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
