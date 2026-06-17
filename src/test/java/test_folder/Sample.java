package test_folder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.joda.time.PeriodType.time;


public class Sample {



    @Test
    public void sample(){
    Map<String,Object> data=new HashMap<>();
        data.put("name","somesh");
        data.put("role","Tester");
        data.put("Gender","Male");

       given()
               .baseUri("https://jsonplaceholder.typicode.com")
               .header("Content-Type","application/json")
               .body(data)
               .when()
               .post("/todos")
               .then()
               .log().all()
               .statusCode(is(201))
               .time(lessThan(5000l))
               .body("name",equalTo("somesh"));


    }
}
