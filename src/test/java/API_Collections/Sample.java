package API_Collections;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class Sample {

    public void getCourse(){
        given()
                .baseUri("https://test.com")

                .when()
                .get("/users")

                .then()
                .statusCode(is(200))
                .log().all();
    }
}
