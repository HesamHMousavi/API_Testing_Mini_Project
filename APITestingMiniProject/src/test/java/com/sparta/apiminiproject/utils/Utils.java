package com.sparta.apiminiproject.utils;


import com.sparta.apiminiproject.pojos.UserAccount;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {

    private static final String BASE_URI = Config.getBaseUri();
    private static final String ALL_PRODUCTS_LIST_PATH = Config.getAllProductsPath();
    private static final String CREATE_USER_ACCOUNT_PATH = Config.getCreateUserAccountPath();
    private static final String DELETE_USER_ACCOUNT_PATH = Config.getDeleteUserAccountPath();
    private static final String Get_User_Account_Detail_Path = "/api/getUserDetailByEmail";
    public String getBaseUri() {
        return  BASE_URI;
    }

    public static RequestSpecification getUserDetailByEmailSpec() {
        return getBaseSpecBuilder(Get_User_Account_Detail_Path)
                .addParam("email","test@gmail.com")
                .build();
    }

    public static RequestSpecification allProductsRequestSpec() {

        return getBaseSpecBuilder(ALL_PRODUCTS_LIST_PATH)
                .build();
    }

    public static RequestSpecification createUserAccountRequestSpec(UserAccount userAccount) {

        return getBaseSpecBuilder(CREATE_USER_ACCOUNT_PATH)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addFormParam("name", userAccount.name())
                .addFormParam("email", userAccount.email())
                .addFormParam("password", userAccount.password())
                .addFormParam("title", userAccount.title())
                .addFormParam("birth_date", userAccount.birthDay())
                .addFormParam("birth_month", userAccount.birthMonth())
                .addFormParam("birth_year", userAccount.birthYear())
                .addFormParam("firstname", userAccount.firstName())
                .addFormParam("lastname", userAccount.lastName())
                .addFormParam("company", userAccount.company())
                .addFormParam("address1", userAccount.address1())
                .addFormParam("address2", userAccount.address2())
                .addFormParam("country", userAccount.country())
                .addFormParam("zipcode", userAccount.zipcode())
                .addFormParam("state", userAccount.state())
                .addFormParam("city", userAccount.city())
                .addFormParam("mobile_number", userAccount.mobileNumber())
                .build();
    }

    private static RequestSpecBuilder getBaseSpecBuilder(String path) {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(path)
                .addHeaders(Map.of("Accept", "application/json"));
    }

    public static void deleteUserAccountIfExists(String email, String password) {

        RestAssured.given().spec(

                        getBaseSpecBuilder(DELETE_USER_ACCOUNT_PATH)
                                .addFormParam("email", email)
                                .addFormParam("password", password)
                                .build()

                )
                .when()
                .delete();
    }
}


