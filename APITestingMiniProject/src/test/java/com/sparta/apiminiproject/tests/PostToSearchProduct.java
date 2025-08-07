package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.Product;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.sparta.apiminiproject.pojos.SearchProductRequest;

import static com.sparta.apiminiproject.utils.JsonParser.htmlToJson;

public class PostToSearchProduct {

    private static Response response;

    @BeforeAll
    public static void beforeAll() {
        SearchProductRequest requestBody = new SearchProductRequest("top");

        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .contentType("application/x-www-form-urlencoded")
                .formParam("search_product", requestBody.getSearchProduct())
                .log().all()
                .when()
                .post("/api/searchProduct")
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Test
    @DisplayName("POST /searchProduct returns status code 200")
    public void statusCodeIs200() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("POST /searchProduct returns non-empty product list")
    public void productListIsNotEmpty() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Strip HTML wrapper so we only have JSON
        String json = htmlToJson(response);

        // Deserialize into POJO
        SearchProductRequest productResponse = mapper.readValue(json, SearchProductRequest.class);

        MatcherAssert.assertThat(productResponse.getProducts(), Matchers.not(Matchers.empty()));
    }


    @Test
    @DisplayName("POST /searchProduct returns products with correct name")
    public void productsContainSearchTerm() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = htmlToJson(response);

        SearchProductRequest productResponse = mapper.readValue(json, SearchProductRequest.class);

        MatcherAssert.assertThat(
                productResponse.getProducts()
                        .stream()
                        .map(Product::getName)
                        .map(String::toLowerCase)
                        .toList()
                        .toString(),
                Matchers.containsString("top")
        );
    }

}
