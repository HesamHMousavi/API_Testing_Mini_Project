package com.sparta.apiminiproject.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utils {
    private static final String BASE_URI = "https://automationexercise.com";
    private static final String Get_User_Account_Detail_Path = "/api/getUserDetailByEmail";
    public String getBaseUri() {
        return  BASE_URI;
    }
    public static RequestSpecification getUserDetailByEmailSpec() {
        return getBaseSpecBuilder(Get_User_Account_Detail_Path)
                .addParam("email","test@gmail.com")
                .build();
    }
    private static RequestSpecBuilder getBaseSpecBuilder(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(path);
    }
}


