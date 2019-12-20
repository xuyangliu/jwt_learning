package com.peanut.jwt_learning.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class AuthServletRequestListener implements ServletRequestListener {

    private static final Logger log = LoggerFactory.getLogger(AuthServletContextListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //计算page view count
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        log.info("---> AuthServletRequestListener.requestInitialized , uri:" + request.getRequestURI());
    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        log.info("---> AuthServletRequestListener.requestDestroyed");
    }
}
