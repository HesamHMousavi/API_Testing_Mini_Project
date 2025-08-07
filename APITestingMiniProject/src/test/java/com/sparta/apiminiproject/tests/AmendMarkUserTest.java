package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.MarkUser;
import com.sparta.apiminiproject.pojos.MarkUserResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmendMarkUserTest {
    private static final Log log = LogFactory.getLog(RegisterMarkUserTest.class);
    private final String email = "mark.blackmore@example.com";
    private final String password = "securePassword123";
    private Response registerResponse;
    private MarkUserResponse markUserResponse;
    private MarkUser user;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://automationexercise.com/api";

        Map<String, String> requestBody = getStringMap();

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

    //gets a map of the fields of the items to be used for deserializing json into a POJO
    private Map<String, String> getStringMap() {
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
    @DisplayName("Update user account using PUT")
    public void updateUserAccountWithPut_Test() {
        Response updateResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", email)
                .formParam("password", password)
                .formParam("name", "Mark Updated")
                .put("/updateAccount");

        System.out.println(updateResponse.asString());
        assertEquals(200, updateResponse.getStatusCode());
        assertEquals("User updated!", updateResponse.jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Update user account fields using csv")
    public void updateUserAccountWithCsv_Test()
    {
        int id = 200000;

        String country, county, address2, city, birthMonth, address1, lname, title, birthYear, birthDay, zipcode, name, company, state, fname;
        country = "India";
        city = "Place";
        address1 = "place place";
        address2 = "Place Place";
        birthMonth = "nov";
        lname = "Blackmore";
        title = "Mr";
        birthYear = "2002";
        birthDay = "26";
        zipcode = "IND234";
        name = "Mark Blackmore";
        company = "Company";
        state = "place";
        fname = "marl";
        county = "place";

        MarkUser updatedFieldsUser = new MarkUser(country, address2, city,
                birthMonth, address1, lname, title, birthYear, birthDay, zipcode, name, company, id, state, fname);
        //sets new user instance to having the same email as user for identification
        updatedFieldsUser.setEmail(user.getEmail());
        Response updateResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", email)
                .formParam("password", password)
                .formParam("name", name)
                .formParam("firstname", fname)
                .formParam("lastname", lname)
                .formParam("country", country)
                .formParam("state", state)
                .formParam("county", county)
                .formParam("city", city)
                .formParam("address1", address1)
                .formParam("address2", address2)
                .formParam("zipcode", zipcode)
                .formParam("birth_day", birthDay)
                .formParam("birth_month", birthMonth)
                .formParam("birth_year", birthYear)
                .formParam("company", company)
                .formParam("id", id)
                .put("/updateAccount");

        System.out.println(updateResponse.asString());
        assertEquals(200, updateResponse.getStatusCode());
        assertEquals("User updated!", updateResponse.jsonPath().getString("message"));

    }

    @AfterEach
    @DisplayName("Delete user account")
    public void deleteUserAccount_Test() {
        Response deleteResponse = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", email)
                .formParam("password", password)
                .delete("/deleteAccount");

        System.out.println(deleteResponse.asString());

    }
}
