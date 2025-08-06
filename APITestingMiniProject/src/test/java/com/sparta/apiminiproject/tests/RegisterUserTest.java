package com.sparta.apiminiproject.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterUserTest {
    Response registerResponse;

    @BeforeEach
    public void setUp() {
        // Set base URI
        RestAssured.baseURI = "https://automationexercise.com/api";

        // Create request body
        // Added a variable for email so it can be changed or potentially refactored
        // for a valuesource entry
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("firstname", "Mark");
        requestBody.put("name", "Mark Blackmore");
        requestBody.put("lastname", "Blackmore");
        requestBody.put("address1", "N/A");
        requestBody.put("country", "India");
        requestBody.put("state", "Place");
        requestBody.put("city", "Place");
        requestBody.put("zipcode", "DH1 3EC");
        requestBody.put("mobile_number", "0783738432");
        requestBody.put("email", "mark.blackmore@example.com");
        requestBody.put("password", "securePassword123");

        // Send POST request
        registerResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(requestBody)
                .post("/createAccount");
    }

    @Test
    @DisplayName("Successfully create user")
    public void SuccessfullyCreateUser_Test() {
        // Print response for debugging
        System.out.println(registerResponse.asString());

        // Assert status code
        assertEquals(200, registerResponse.getStatusCode());

        // Optionally assert response content
        assertEquals("User created!", registerResponse.jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Delete user account")
    public void deleteUserAccount_Test() {
        Response deleteResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", "mark.blackmore@example.com")
                .formParam("password", "securePassword123")
                .delete("/deleteAccount");

        //debugging
        System.out.println(deleteResponse.asString());

        // Assert status code
        assertEquals(200, deleteResponse.getStatusCode());

        // Optionally assert response content
        assertEquals("Account deleted!", deleteResponse.jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Update user account using PUT")
    public void updateUserAccountWithPut_Test() {
        Response updateResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", "mark.blackmore@example.com")
                .formParam("password", "securePassword123")
                .formParam("name", "Mark Updated") // field to update
                .put("/updateAccount");

        //debugging
        System.out.println(updateResponse.asString());

        //assert status code and message
        assertEquals(200, updateResponse.getStatusCode());
        assertEquals("User updated!", updateResponse.jsonPath().getString("message"));
    }

}
