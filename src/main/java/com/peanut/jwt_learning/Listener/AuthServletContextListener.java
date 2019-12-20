package com.peanut.jwt_learning.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class AuthServletContextListener implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(AuthServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("<--- AuthServletContextListener.contextInitialized --->");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("<--- AuthServletContextListener.contextDestroyed --->");
    }

}
