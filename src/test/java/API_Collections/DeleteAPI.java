package API_Collections;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAPI {
    private static final Logger logger = LogManager.getLogger(DeleteAPI.class);
    @Test
    public void verifyDeletedata(){
        Response respose=

                given()
                        .baseUri("https://dummy.restapiexample.com/api/v1")

                        .when()
                        .delete("/delete/716");

        //validate delete
        String status=respose.jsonPath().getString("status");
        Assert.assertEquals(status, "success", "Delete API failed");
        logger.info("Test is pass:successfully! deleted Records: "+status);


    }
}
