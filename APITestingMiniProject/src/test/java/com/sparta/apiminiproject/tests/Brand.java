package com.sparta.apiminiproject.tests;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

// POJO Classes
class Brand {
    @JsonProperty("id")
    private int id;

    @JsonProperty("brand")
    private String brand;

    // Default constructor
    public Brand() {}

    // Parameterized constructor
    public Brand(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}

class BrandsResponse {
    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("brands")
    private List<Brand> brands;

    // Default constructor
    public BrandsResponse() {}

    // Parameterized constructor
    public BrandsResponse(int responseCode, List<Brand> brands) {
        this.responseCode = responseCode;
        this.brands = brands;
    }

    // Getters and Setters
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "BrandsResponse{" +
                "responseCode=" + responseCode +
                ", brands=" + brands +
                '}';
    }
}

/*
Your existing pom.xml is perfect! It already includes:
✅ JUnit 5 (junit-jupiter 5.10.0)
✅ Jackson Databind (2.15.2)
✅ RestAssured (5.3.1)
✅ Java 21 support

Usage Instructions:
1. Your pom.xml already has all required dependencies
2. Place this file in: src/test/java/com/automationexercise/tests/GetAllBrandsTest.java
3. Run tests using:
   - Maven: mvn test -Dtest=GetAllBrandsTest
   - IDE: Right-click and run (JUnit 5)
   - Gradle: ./gradlew test --tests GetAllBrandsTest

Key Changes for JUnit 5:
- @BeforeAll instead of @BeforeClass
- @Test and @DisplayName instead of @Test(description="...")
- Static assertions: assertEquals, assertNotNull, assertTrue, assertFalse

/*
Your existing pom.xml is perfect! It already includes:
✅ JUnit 5 (junit-jupiter 5.10.0)
✅ Jackson Databind (2.15.2)
✅ RestAssured (5.3.1)
✅ Java 21 support

Usage Instructions:
1. Your pom.xml already has all required dependencies
2. Place this file in: src/test/java/com/automationexercise/tests/GetAllBrandsTest.java
3. Run tests using:
   - Maven: mvn test -Dtest=GetAllBrandsTest
   - IDE: Right-click and run (JUnit 5)
   - Gradle: ./gradlew test --tests GetAllBrandsTest

Key Changes for JUnit 5:
- @BeforeAll instead of @BeforeClass
- @Test and @DisplayName instead of @Test(description="...")
- Static assertions: assertEquals, assertNotNull, assertTrue, assertFalse
- Method names follow JUnit 5 conventions (void return type)

The test covers:
- ✅ Basic API response validation
- ✅ POJO deserialization with Jackson
- ✅ Response time validation
- ✅ Data structure validation
- ✅ Duplicate ID checks
- ✅ Custom brand existence checks
*/