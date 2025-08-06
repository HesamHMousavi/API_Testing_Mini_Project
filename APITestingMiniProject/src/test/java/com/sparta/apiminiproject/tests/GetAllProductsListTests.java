package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.ProductsList;
import com.sparta.apiminiproject.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GetAllProductsListTests {

    private static ProductsList productsList;

    @BeforeAll
    static void beforeAll() throws Exception {

        Response response = RestAssured
                .given()
                .spec(Utils.allProductsRequestSpec())
                .when()
                .get()
                .then()
//                .log().all()
                .extract().response();

        var productsListString = Jsoup.parse(response.body().asString()).text();

        var mapper = new ObjectMapper();
        productsList = mapper.readValue(productsListString, ProductsList.class);
    }

    @Test
    void getAllProductsList_ReturnCorrectStatusCode() {
        MatcherAssert.assertThat(productsList.getResponseCode(), Matchers.is(200));
    }

    @Test
    void getAllProductsList_ReturnCorrectProductCount() {
        MatcherAssert.assertThat(productsList.getProducts().size(), Matchers.is(34));
    }

    @Test
    void getAllProductsList_HasCorrectProduct() {

        var productItemsWithId1List = productsList.getProducts().stream()
                .filter(productItem -> productItem.getId() == 1)
                .toList();

        MatcherAssert.assertThat(productItemsWithId1List.size(), Matchers.is(1));

        var productItemWithId1 = productItemsWithId1List.getFirst();

        MatcherAssert.assertThat(productItemWithId1.getId(), Matchers.is(1));
        MatcherAssert.assertThat(productItemWithId1.getName(), Matchers.is("Blue Top"));
        MatcherAssert.assertThat(productItemWithId1.getPrice(), Matchers.is("Rs. 500"));
        MatcherAssert.assertThat(productItemWithId1.getBrand(), Matchers.is("Polo"));
        MatcherAssert.assertThat(productItemWithId1.getCategory().getUsertype().getUsertype(),
                Matchers.is("Women"));
        MatcherAssert.assertThat(productItemWithId1.getCategory().getCategory(), Matchers.is("Tops"));
    }
}
