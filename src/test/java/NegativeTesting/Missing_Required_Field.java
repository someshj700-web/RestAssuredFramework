package NegativeTesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Missing_Required_Field {

    @Test
    public void testMissingField() {
        Response response=given()
                .baseUri("https://reqres.in/api")
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"morpheus\" }") // missing job field
                .when()
                .post("/users");
                response.then().statusCode(400); // Bad Request
    }
}
