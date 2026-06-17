package test_folder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;

public class SchemaValidationTest {


    @Test
    public void validateUserSchema() {


   Response response=
        given()
                .baseUri("https://jsonplaceholder.typicode.com")

                .when()
                .get("/users/2");



                response.then().statusCode(200)
                .log().all()
                        .body(matchesJsonSchemaInClasspath("userschema.json"));

    }
}