package com.peanut.jwt_learning.Exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@AllArgsConstructor
@NoArgsConstructor
public class AuthException extends RuntimeException{

    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }


}
