package com.peanut.jwt_learning.Exception;

import com.peanut.jwt_learning.Util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String auth_exception_handler(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return ResponseUtil.returnException(e.getMessage());
    }
}
