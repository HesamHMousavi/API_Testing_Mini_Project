package com.sparta.apiminiproject.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiminiproject.pojos.User;
import com.sparta.apiminiproject.utils.Config;
import com.sparta.apiminiproject.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getUserDetailByEmail {

    private static Response response;
private static User user;
    @BeforeAll
    static void beforeAll() throws Exception {

        response = RestAssured
                .given()
                .spec(Utils.getUserDetailByEmailSpec())
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        String responseJson = responseBody.replaceAll("(?s)<[^>]*>", "").trim();
        ObjectMapper mapper = new ObjectMapper();
         user = mapper.readValue(responseJson, User.class);
    }

    @Test
    void verifyResponseCode() {
        assertEquals(200, user.getResponseCode());
    }

    @Test
    void verifyUserId() {
        MatcherAssert.assertThat(user.getUser().getId(), Matchers.is(445));
    }
}
