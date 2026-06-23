package base_folder;

import Util.HeaderUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.hamcrest.Matchers.lessThan;

public class BaseClass {
    protected RequestSpecification requestSpec;
    protected ResponseSpecification successResponseSpec;
    protected ResponseSpecification createdResponseSpec;

    @BeforeMethod
    public void setup1(){
        requestSpec= new RequestSpecBuilder()
                 .setBaseUri("https://jsonplaceholder.typicode.com")
                 .addHeaders(HeaderUtils.getCommonHeaders())
                 //.addHeaders(HeaderUtils.getAuthHeader())
                 .build();

    }

    @BeforeMethod
    public void setup2() {

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(3000L))
                .build();
    }

    @BeforeMethod
    public void setup3() {

        createdResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(3000L))
                .build();
    }

}
