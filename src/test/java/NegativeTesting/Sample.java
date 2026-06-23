package NegativeTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Sample {
    @Test
    public void verifyFileUpload(){
        File testFile = new File("src/test/resources/Log4j2.xml");

       given()
                .baseUri("https://api.escuelajs.co/api/v1/files/upload")
                // २. multiPart मेथड वापरा (Key आणि File Object)
                .multiPart("file", testFile)
                .header("Content-Type", "multipart/form-data")
                .when()
                .post("/upload")
                .then()
                
                .log().all();

    }

}
