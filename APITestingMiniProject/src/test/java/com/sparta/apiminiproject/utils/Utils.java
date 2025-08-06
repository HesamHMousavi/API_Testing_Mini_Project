package com.sparta.apiminiproject.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {

    private static final String BASE_URI = Config.getBaseUri();
    private static final String ALL_PRODUCTS_LIST_PATH = Config.getAllProductsPath();

    public String getBaseUri() {
        return  BASE_URI;
    }

    public static RequestSpecification allProductsRequestSpec() {

        return getBaseSpecBuilder(ALL_PRODUCTS_LIST_PATH)
                .build();
    }

    private static RequestSpecBuilder getBaseSpecBuilder(String path) {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(path)
                .addHeaders(Map.of("Accept", "application/json"));
    }
}
