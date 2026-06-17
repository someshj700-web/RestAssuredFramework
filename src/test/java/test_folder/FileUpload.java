package test_folder;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUpload {
    public static void main(String[] args) {
        File pdfFile = new File("C:\\Users\\somes\\Downloads\\RestAssured\\src\\test\\resources\\userschema.json");

        given()
                .baseUri("https://api.escuelajs.co/api/v1/files")
                .multiPart("file", pdfFile)
                .contentType("multipart/form-data")

                .when()
                .post("/upload")

                .then()
                .statusCode(201)
                .log().all();
    }
}
