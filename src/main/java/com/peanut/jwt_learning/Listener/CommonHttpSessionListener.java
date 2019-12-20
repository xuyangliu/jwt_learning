package com.peanut.jwt_learning.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class CommonHttpSessionListener implements HttpSessionListener {

    private static final Logger log = LoggerFactory.getLogger(CommonHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("<--- CommonHttpSessionListener.sessionCreated --->");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("<--- CommonHttpSessionListener.sessionDestroyed --->");
    }

}
