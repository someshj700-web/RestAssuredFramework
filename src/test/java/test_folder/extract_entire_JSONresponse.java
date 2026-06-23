package test_folder;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class extract_entire_JSONresponse {

    @Test
    public void veriyAlluserdata(){
        Response response=
                given()
                        .baseUri("https://dummy-json.mock.beeceptor.com/users/1")

                        .when()
                        .get("");

        Map<String,Object> user =response.jsonPath().getMap("");

        System.out.println(user);



    }
}
