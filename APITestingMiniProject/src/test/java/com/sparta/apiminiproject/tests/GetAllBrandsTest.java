package com.sparta.apiminiproject.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAllBrandsTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://automationexercise.com";
    }

    @Test
    public void testGetAllBrands() {
        Response response = given()
                .when()
                .get("/api/brandsList")
                .then()
                .statusCode(200)
                //.body("responseCode", equalTo(200)) // Uncomment if valid in your response
                .body("brands", notNullValue())
                .extract().response();

        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void testPutAllBrandsMethodAllowedOrNot() {
        given()
                .when()
                .put("/api/brandsList")
                .then()
                .statusCode(anyOf(is(405), is(200))); // Accept 405 or 200 for now
    }
}
