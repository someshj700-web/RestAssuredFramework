package test_folder;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
public class Sample2 {

    private static final Logger logger = LogManager.getLogger(Sample2.class);
    @Test
    public void verify(){


        Response response =
                given()
                        .baseUri("https://jsonplaceholder.typicode.com/")

                        .when()
                        .get("/posts/2");



        // Status Code Validation
        Assert.assertEquals(response.getStatusCode(), 200,"Test is failed");
        logger.info("Test is Passed");

        //Response body Validation using jsonPath()
        Assert.assertEquals(response.jsonPath().getString("title"), "qui est esse", "Title mismatch");
        logger.info("Test is Passed");

        // Response Time Validation
        Assert.assertTrue(response.getTime()< 5000,"Test is failed");
        logger.info("Test is Passed");


        //Header Validation
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8",
                "Content-Type header mismatch");
        logger.info("Test is Passed");

    }


}
