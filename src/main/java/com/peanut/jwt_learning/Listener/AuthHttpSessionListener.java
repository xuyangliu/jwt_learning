package com.peanut.jwt_learning.Listener;

import com.peanut.jwt_learning.Interceptor.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class AuthHttpSessionListener implements HttpSessionListener {

    private static final Logger log = LoggerFactory.getLogger(AuthHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("---> AuthHttpSessionListener.sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("---> AuthHttpSessionListener.sessionDestroyed");
    }

}
