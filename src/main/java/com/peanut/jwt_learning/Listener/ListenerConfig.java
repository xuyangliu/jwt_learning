package com.peanut.jwt_learning.Listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean commonServletContextListener(){
        ServletListenerRegistrationBean<CommonServletContextListener> commonServletContextListener = new ServletListenerRegistrationBean<>(new CommonServletContextListener());
        return commonServletContextListener;
    }

    @Bean
    public ServletListenerRegistrationBean commonServletRequestListener(){
        ServletListenerRegistrationBean<CommonServletRequestListener> commonServletRequestListener = new ServletListenerRegistrationBean<>(new CommonServletRequestListener());
        return commonServletRequestListener;
    }

    @Bean
    public ServletListenerRegistrationBean commonHttpSessionListener(){
        ServletListenerRegistrationBean<CommonHttpSessionListener> commonHttpSessionListener = new ServletListenerRegistrationBean<>(new CommonHttpSessionListener());
        return commonHttpSessionListener;
    }
}
