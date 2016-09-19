package org.fundacionjala.pivotalapi.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.response.Response;

import static io.restassured.path.json.JsonPath.from;

/**
 * Class that parses an pseudo URL into a valid URL
 */
public final class Mapper {
    public static final Map<String, Response> RESPONSE_VALUES = new HashMap<String, Response>();

    private static final String REGEX_INSIDE_BRACKETS = "(?<=\\[)(.*?)(?=\\])";

    private static final String REGEX_DOT = "\\.";

    private static final String REGEX_BRACKETS = "[\\[\\]]";

    private Mapper() {
    }


    /**
     * Method that returns the specif field with a response and a parameter.
     *
     * @param response The response to get the field.
     * @param parameter The parameter
     * @return The field with a response and a parameter.
     */
    public static String getField(Response response, String parameter) {
        return from(response.asString()).get(parameter).toString();
    }

    /**
     *Method that replaces everything including the brackets.
     *
     * @param endPoint
     * @return
     */
    public static String mapEndpoint(String endPoint) {
       return mapBodyJson(endPoint).replaceAll(REGEX_BRACKETS, "");
    }

    /**
     * Method that replaces everything that is between the brackets.
     *
     * @param body
     * @return
     */
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


    /**
     * Method that adds a new key with the hash with all its response.
     *
     * @param key
     * @param response
     */
    public static void addResponse(String key, Response response) {

        RESPONSE_VALUES.put(key, response);
    }
}
