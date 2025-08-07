package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.Category;
import com.sparta.apiminiproject.pojos.ProductsItem;
import com.sparta.apiminiproject.pojos.Usertype;
import com.sparta.apiminiproject.utils.Utils;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PostAllProductsListTests {

    private static JsonNode errorResponse;

    @BeforeAll
    static void beforeAll() throws Exception {

        var newProduct = new ProductsItem();
        newProduct.setPrice("£10 or Best offer");
        newProduct.setName("Long Johns");
        newProduct.setBrand("Chillies");

        var userType = new Usertype();
        userType.setUsertype("Mens");

        var category = new Category();
        category.setUsertype(userType);
        category.setCategory("Bottoms");

        newProduct.setCategory(category);

        var response = RestAssured
                .given()
                .spec(Utils.allProductsRequestSpec())
                .body(newProduct)
                .when()
                .post()
                .then()
//                .log().all()
                .extract().response();

        var errorResponseString = Jsoup.parse(response.body().asString()).text();

        var mapper = new ObjectMapper();
        errorResponse = mapper.readTree(errorResponseString);
    }

    @Test
    void postAllProductsList_Returns405ResponseCode() {
        MatcherAssert.assertThat(errorResponse.get("responseCode").asLong(), Matchers.is(405L));
    }

    @Test
    void postAllProductsList_ReturnsCorrectErrorMessage() {
        MatcherAssert.assertThat(errorResponse.get("message").asText(),
                Matchers.is("This request method is not supported."));
    }
}
