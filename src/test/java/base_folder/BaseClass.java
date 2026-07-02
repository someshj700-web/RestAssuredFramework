package base_folder;

import Util.HeaderUtils;
import auth.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.Matchers.lessThan;

public class BaseClass {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification successResponseSpec;
    protected ResponseSpecification createdResponseSpec;
    protected String token;

    @BeforeMethod
    public void setup() {

         token = TokenManager.getToken();
         System.out.println("Login API Called:Token is generated >> "+token);

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com")
                .addHeaders(HeaderUtils.getCommonHeaders())
                .addHeader("Authorization", "Bearer " + token)
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(3000L))
                .build();

        createdResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(3000L))
                .build();
    }

}
