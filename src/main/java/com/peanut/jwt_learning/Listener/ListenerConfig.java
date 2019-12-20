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
    public ServletListenerRegistrationBean authServletContextListener(){
        ServletListenerRegistrationBean<AuthServletContextListener> authServletContextListener = new ServletListenerRegistrationBean<>(new AuthServletContextListener());
        return authServletContextListener;
    }

    @Bean
    public ServletListenerRegistrationBean authServletRequestListener(){
        ServletListenerRegistrationBean<AuthServletRequestListener> authServletRequestListener = new ServletListenerRegistrationBean<>(new AuthServletRequestListener());
        return authServletRequestListener;
    }

    @Bean
    public ServletListenerRegistrationBean authHttpSessionListener(){
        ServletListenerRegistrationBean<AuthHttpSessionListener> authHttpSessionListener = new ServletListenerRegistrationBean<>(new AuthHttpSessionListener());
        return authHttpSessionListener;
    }
}
