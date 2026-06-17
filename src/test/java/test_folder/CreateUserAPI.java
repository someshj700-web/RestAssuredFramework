package test_folder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateUserAPI {

    String id;

    @Test
    public  void createUser() {

        Response response1 =
                given()
                        .baseUri("https://jsonplaceholder.typicode.com")
                        .body("{\"userId\":\"10\",\"id\":\"101\"}")

                        .when()
                        .post("/posts");



        id = response1.jsonPath().getString("id");

        System.out.println("ID: " + id);
    }

    @Test
    public void getUser() {
        Response response2 =given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts"+id);
               response2.prettyPrint();

        String UserID=response2.jsonPath().getString("userid");

    }
    @Test
    public void updateUser(){
        Response response3=given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .body("{\"userId\":12}")
                .when()
                .put("/update/id");
                String UserID=response3.jsonPath().getString("userid");


    }
}