package org.fundacionjala.pivotalapi.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.path.json.JsonPath.from;

/**
 * Created by AngelaValdez on 9/13/2016.
 */
public final class Mapper {
    public static final Map<String, Response> RESPONSE_VALUES = new HashMap<String, Response>();

    private static final String REGEX_INSIDE_BRACKETS = "(?<=\\[)(.*?)(?=\\])";

    private static final String REGEX_DOT = "\\.";

    private static final String REGEX_BRACKETS = "[\\[\\]]";

    private Mapper() {
    }

    public static String getField(Response response, String parameter) {
        return from(response.asString()).get(parameter).toString();
    }

    public static String mapEndpoint(String endPoint) {
       return mapBodyJson(endPoint).replaceAll(REGEX_BRACKETS, "");
    }

    public static String mapBodyJson (String body){
        Matcher matches = Pattern.compile(REGEX_INSIDE_BRACKETS).matcher(body);
        StringBuffer newEndPoint = new StringBuffer();

        while (matches.find()) {
            String[] parametersParts = matches.group().split(REGEX_DOT, 2);
            String key = parametersParts[0];
            String value = parametersParts[1];
            String replaceParameter = Mapper.getField(RESPONSE_VALUES.get(key), value);
            matches.appendReplacement(newEndPoint, replaceParameter);
        }
        matches.appendTail(newEndPoint);
        return newEndPoint.toString();
    }
    public static void addResponse(String key, Response response) {
        RESPONSE_VALUES.put(key, response);
    }
}
