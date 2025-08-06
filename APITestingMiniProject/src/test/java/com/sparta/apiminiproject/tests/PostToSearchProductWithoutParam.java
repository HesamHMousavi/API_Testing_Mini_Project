package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.SearchProductErrorResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.apiminiproject.utils.JsonParser.htmlToJson;

public class PostToSearchProductWithoutParam {

    private static Response response;

    @BeforeAll
    public static void beforeAll() {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .contentType("application/x-www-form-urlencoded")
                // No formParam here
                .log().all()
                .when()
                .post("/api/searchProduct")
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Test
    @DisplayName("POST /searchProduct without parameter returns status code 400")
    public void statusCodeIs400() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = htmlToJson(response); // Use your utility method

        SearchProductErrorResponse errorResponse = mapper.readValue(json, SearchProductErrorResponse.class);

        MatcherAssert.assertThat(errorResponse.getResponseCode(), Matchers.is(400));
    }


    @Test
    @DisplayName("POST /searchProduct without parameter returns correct error message")
    public void errorMessageIsCorrect() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = htmlToJson(response);
        // Map JSON to POJO
        SearchProductErrorResponse errorResponse = mapper.readValue(json, SearchProductErrorResponse.class);

        MatcherAssert.assertThat(errorResponse.getMessage(),
                Matchers.is("Bad request, search_product parameter is missing in POST request."));
    }
}
