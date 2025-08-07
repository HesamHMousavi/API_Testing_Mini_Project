package com.sparta.apiminiproject.pojos;

public record UserAccount(

        String name,
        String email,
        String password,
        String title,
        String birthDay,
        String birthMonth,
        String birthYear,
        String firstName,
        String lastName,
        String company,
        String address1,
        String address2,
        String country,
        String zipcode,
        String state,
        String city,
        String mobileNumber
) {}
