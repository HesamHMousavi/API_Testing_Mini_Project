package com.sparta.apiminiproject.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class PutBrandsTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://automationexercise.com";
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
