package com.peanut.jwt_learning.Exception;

import com.peanut.jwt_learning.Util.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String auth_exception_handler(Exception e){
        return ResponseUtil.returnException();
    }
}
