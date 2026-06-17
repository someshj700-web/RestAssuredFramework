package base_folder;

import Util.HeaderUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .addHeaders(HeaderUtils.getCommonHeaders()) // HeaderUtil चा वापर
                .build();
    }
}
