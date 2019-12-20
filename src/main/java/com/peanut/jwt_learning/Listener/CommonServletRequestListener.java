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
public class CommonServletRequestListener implements ServletRequestListener {

    private static final Logger log = LoggerFactory.getLogger(CommonServletContextListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        log.info("<--- CommonServletRequestListener.requestInitialized --->");
    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        log.info("<--- CommonServletRequestListener.requestDestroyed --->");
    }
}
