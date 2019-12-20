package com.peanut.jwt_learning.Filter;

import com.peanut.jwt_learning.Service.TokenService;
import com.peanut.jwt_learning.Util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
public class AuthFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("<--- AuthFilter.init() --->");
    }

    @Override
    public void destroy() {
        log.info("<--- AuthFilter.destroy() --->");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        log.info("<--- AuthFilter.doFilter() start --->");

        if (!url.endsWith("login") && request.getHeader("token") == null){
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(ResponseUtil.returnBusinessException("无token，请重新登录"));
            log.info("<--- AuthFilter.doFilter() end --->");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);

        log.info("<--- AuthFilter.doFilter() end --->");
    }

}
