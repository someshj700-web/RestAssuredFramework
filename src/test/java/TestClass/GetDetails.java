package TestClass;

import base_folder.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetDetails extends BaseClass {

    @Test
    public void createUser(){
        Map<String,Object> boddy=new LinkedHashMap<>();
        boddy.put("userId",1);
        boddy.put("body","soma");
        boddy.put("title","rama");


        given()
                .spec(requestSpec)
                .body(boddy)

                .when()
                .post("/posts")

                .then()
                .spec(createdResponseSpec);
    }

    @Test
    public void verifydetails(){
  Response response=
        given()
                .spec(requestSpec)
                .when()
                .get("/comments");//end statement

        response.then()
                .spec(successResponseSpec);

        response.prettyPrint();

        //int postid=response.jsonPath().getInt("postId[1]");
        //int id=response.jsonPath().getInt("id[1]");

        //Assert.assertEquals(postid,1);
        //Assert.assertEquals(id,2);
    }

    @Test
    public void deleteuser(){
        given()
                .spec(requestSpec)
                .when()
                .delete("/posts/1")

                .then()
                .spec(successResponseSpec);
    }
}
