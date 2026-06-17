package API_Collections;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutAPI {
    private static final Logger logger= LogManager.getLogger(PutAPI.class);

    @Test
    public void verifyupdatedata(){
        Response response=
                given()
                        .baseUri("https://dummy.restapiexample.com/api/v1")
                        .body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
                        .when()
                        .put("/update/25");
        //response.prettyPrint();

        //validate put API
        String name=response.jsonPath().getString("data.name");
        Assert.assertEquals(name,"[]","Incorrect Name");
        logger.info("Test is pass ,Correct id recieved:"+name);

    }
}
