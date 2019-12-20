package com.peanut.jwt_learning.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peanut.jwt_learning.Constant.ResponseStatus;

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
        return returnJson(ResponseStatus.SERVER_EXCEPTION.code(), ResponseStatus.SERVER_EXCEPTION.message(), null);
    }

    public static String returnException(String message) {
        return returnJson(ResponseStatus.SERVER_EXCEPTION.code(), message, null);
    }

    public static String returnBusinessException() {
        return returnJson(ResponseStatus.BUSINESS_EXCEPTION.code(), ResponseStatus.BUSINESS_EXCEPTION.message(), null);
    }

    public static String returnBusinessException(String message) {
        return returnJson(ResponseStatus.BUSINESS_EXCEPTION.code(), message, null);
    }

    public static String returnSuccess() {
        return returnJson(ResponseStatus.SUCCESS.code(), ResponseStatus.SUCCESS.message(),null);
    }

    public static String returnJson(Object data) {
        return returnJson(ResponseStatus.SUCCESS.code(), ResponseStatus.SUCCESS.message(),data);
    }

    public static String returnJson(Integer code, String message, Object data){

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
