package auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenManager {

    private static String token;

    public static String getToken(){
        String payload = """
        {
          "username": "emilys",
          "password": "emilyspass",
          "expiresInMins": 30
        }
        """;

        Response response = RestAssured
                .given()
                .baseUri("https://dummyjson.com")
                .header("Content-Type", "application/json")
                .body(payload)

                .when()
                .post("/auth/login");

        token = response.jsonPath().getString("accessToken");

        return token;


    }
}
