package com.metacoding.authblog._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MerongFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String path = req.getRequestURI();
        if (path.startsWith("/board") || path.startsWith("/user")) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("메롱");
        chain.doFilter(request, response);
    }
}
