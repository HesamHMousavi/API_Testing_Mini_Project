package com.sparta.apiminiproject.utils;
import io.restassured.response.Response;

public class JsonParser {

    public static String htmlToJson(Response response) {
        return response.asString()
            .replace("<html>", "")
            .replace("</html>", "")
            .replace("<body>", "")
            .replace("</body>", "");
    }
}
