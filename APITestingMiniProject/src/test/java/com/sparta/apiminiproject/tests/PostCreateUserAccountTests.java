package com.sparta.apiminiproject.tests;

import com.sparta.apiminiproject.pojos.UserAccount;
import com.sparta.apiminiproject.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PostCreateUserAccountTests {

    private static JSONObject createdUserAccountResponse;

    @BeforeAll
    static void beforeAll() throws Exception {

        String newUserPassword = "password",
                newUserEmail = "email65421@example.com";

        Utils.deleteUserAccountIfExists(newUserEmail, newUserPassword);

        Response response = RestAssured
                .given()
                .spec(Utils.createUserAccountRequestSpec(

                        new UserAccount(
                                "johnsmith1234",
                                newUserEmail,
                                newUserPassword,
                                "Mr",
                                "1",
                                "January",
                                "2000",
                                "John",
                                "Smith",
                                "Toys R Us",
                                "Address line 1",
                                "Address line 2",
                                "Country",
                                "SW19",
                                "State",
                                "City",
                                "5555 555 555"
                        )))
                .when()
                .post()
                .then()
                .extract().response();

        var createdUserAccountResponseString = Jsoup.parse(response.body().asString()).text();

        var jsonParser = new JSONParser();
        createdUserAccountResponse = (JSONObject)jsonParser.parse(createdUserAccountResponseString);
    }

    @Test
    void postCreateUserAccount_ReturnsCorrectResponseCode() {
        MatcherAssert.assertThat(createdUserAccountResponse.get("responseCode"), Matchers.is(201L));
    }

    @Test
    void postCreateUserAccount_ReturnsCorrectMessage() {
        MatcherAssert.assertThat(createdUserAccountResponse.get("message"), Matchers.is("User created!"));
    }
}
