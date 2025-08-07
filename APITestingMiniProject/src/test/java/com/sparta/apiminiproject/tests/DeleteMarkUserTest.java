package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.MarkUser;
import com.sparta.apiminiproject.pojos.MarkUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteMarkUserTest {
    private static final Log log = LogFactory.getLog(RegisterMarkUserTest.class);
    private final String email = "mark.blackmore@example.com";
    private final String password = "securePassword123";
    private Response registerResponse;
    private MarkUserResponse markUserResponse;
    private MarkUser user;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://automationexercise.com/api";

        Map<String, String> requestBody = getStringStringMap();

        registerResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(requestBody)
                .post("/createAccount");

        Response getUserResponse = RestAssured
                .given()
                .queryParam("email", email)
                .get("/getUserDetailByEmail");

        String json = getUserResponse.asString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            markUserResponse = mapper.readValue(json, MarkUserResponse.class);
            user = markUserResponse.getUser();
        } catch(Exception e) {
            System.out.println("USER NOT INSTANTIATED");
            e.printStackTrace();
        }


        System.out.println("User ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Country: " + user.getCountry());
        System.out.println("Address1: " + user.getAddress1());
        System.out.println("Address2: " + user.getAddress2());
        System.out.println("Zipcode: " + user.getZipcode());

    }

    private Map<String, String> getStringStringMap() {
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
        requestBody.put("email", email);
        requestBody.put("password", password);
        return requestBody;
    }

    @Test
    @DisplayName("Successfully create user")
    public void SuccessfullyCreateUser_Test() {
        System.out.println(registerResponse.asString());
        assertEquals(200, registerResponse.getStatusCode());
        assertEquals("User created!", registerResponse.jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Deserialize user JSON into POJO")
    public void deserializeUserJson_Test() throws Exception {
        assertEquals(200, markUserResponse.getResponseCode());
    }

    @Test
    @DisplayName("Delete user account")
    public void deleteUserAccount_Test() {
        Response deleteResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", email)
                .formParam("password", password)
                .delete("/deleteAccount");

        System.out.println(deleteResponse.asString());
        assertEquals(200, deleteResponse.getStatusCode());
        assertEquals("Account deleted!", deleteResponse.jsonPath().getString("message"));
    }

}
