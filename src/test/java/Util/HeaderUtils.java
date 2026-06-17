package Util;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtils {


    public static Map<String, String> getCommonHeaders() {

        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        return headers;
    }


}

