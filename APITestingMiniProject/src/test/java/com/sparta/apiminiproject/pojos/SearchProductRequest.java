package com.sparta.apiminiproject.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SearchProductRequest {

    // Request field
    @JsonProperty("search_product")
    private String searchProduct;

    // Response fields
    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("products")
    private List<Product> products;

    public SearchProductRequest() {
    }

    public SearchProductRequest(String searchProduct) {
        this.searchProduct = searchProduct;
    }

    // Getters & Setters
    public String getSearchProduct() {
        return searchProduct;
    }

    public void setSearchProduct(String searchProduct) {
        this.searchProduct = searchProduct;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
