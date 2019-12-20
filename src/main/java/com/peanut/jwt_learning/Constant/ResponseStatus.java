package com.peanut.jwt_learning.Constant;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public enum ResponseStatus {
    SUCCESS(200, "success"),
    SERVER_EXCEPTION(400, "server exception"),
    BUSINESS_EXCEPTION(500, "business exception");

    private final int code;
    private final String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
