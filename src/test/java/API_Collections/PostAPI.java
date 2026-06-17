package API_Collections;



import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostAPI {
    private static final Logger logger= LogManager.getLogger(PostAPI.class);


    @Test
    public void verifyPostApI(){

        Map<String,Object>detaa=new HashMap<>();
        detaa.put("name","Jane Doe");
        detaa.put("email","jane@example.com");
        detaa.put("role","admin");



                given()
                        .baseUri("https://reqres.in/")
                        .header("Content-Type","application/json")
                        .body(detaa)

                        .when()
                        .post("api/test-suite/collections/users/records")


                        .then()
                        .log().all();






    }
}
