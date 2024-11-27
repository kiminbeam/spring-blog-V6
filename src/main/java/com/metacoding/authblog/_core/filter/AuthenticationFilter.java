package com.metacoding.authblog._core.filter;

import com.metacoding.authblog.user.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Pattern;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터 돌고있습니까???");

        // 다운캐스트
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        //localhost:8080/board/hello
        String path = req.getRequestURI();

        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            res.sendRedirect("/login-form");
        } else {
            chain.doFilter(request, response);
        }
    }
}
