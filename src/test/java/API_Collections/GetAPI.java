package API_Collections;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class GetAPI {
    private static final Logger logger = LogManager.getLogger(GetAPI.class);
    @Test
    public void verifyTheAPI() {
        Response response =
                given().
                        baseUri("https://jsonplaceholder.typicode.com")


                        .when()
                        .get("/posts/");
        //response.then().statusCode(201);
        //response.then().time(lessThan(1000L));
        //response.prettyPrint();
        //response.then().log().all();
        System.out.println(response.getBody().asString());

        //validate statusCode
        int actualstatuscode = response.getStatusCode();
        Assert.assertEquals(actualstatuscode, 200, "Test failed: Incorrect status code received");
        logger.info("Test passed: Correct status code received :" + actualstatuscode);


        // validate Response Time
        float actualtime = response.getTime();
        Assert.assertTrue(actualtime < 3000, "Response time is too high");
        logger.info("Test passed: APi return given time :" + actualtime);

        // validate Headers
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8","Incorrect header received");
        logger.info("Test passed: Correct header received :" + contentType);

        // validate Response Body
//        String name = response.jsonPath().getString("name");
//        String lastName = response.jsonPath().getString("lastname");
//        String mobile = response.jsonPath().getString("mobile");
//        String gender = response.jsonPath().getString("gender");
//
//        Assert.assertEquals(name, "ravi","Name mismatch");
//        logger.info("Test is pass:Correct Name found "+name);
//        Assert.assertEquals(lastName, "Jadhav","Last name mismatch");
//        logger.info("Test is pass:Correct LastName found "+lastName);
//        Assert.assertEquals(mobile, "9876543210", "Mobile number mismatch");
//        logger.info("Test is pass:Correct Mobile found "+mobile);
//        Assert.assertEquals(gender, "male","Gender mismatch");
//        logger.info("Test is pass:Correct Gender found "+gender);
    }
}
