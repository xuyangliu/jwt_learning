package com.peanut.jwt_learning.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
public class ResponseUtil {

    private final static String CODE = "code";
    private final static String MESSAGE = "message";
    private final static String DATA = "data";

    public static String returnException() {
        return returnJson("400", "server failure", null);
    }

    public static String returnBusinessException(String message) {
        return returnJson("400", message, null);
    }

    public static String returnJson(Object data) {
        return returnJson("200","success",data);
    }

    public static String returnJson(String code, String message, Object data){

        String resultJson = "";
        Map<String, Object> result = new HashMap<>();
        result.put(CODE, code);
        result.put(MESSAGE, message);
        result.put(DATA, data);

        try {
            resultJson = new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return resultJson;
        }
    }

}
