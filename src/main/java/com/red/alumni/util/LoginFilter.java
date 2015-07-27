package com.red.alumni.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.red.alumni.bean.Userbean;

public class LoginFilter implements Filter {

    protected FilterConfig filterConfig;

    public void destroy() {
        filterConfig = null;
    }

    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getRequestURI();

        response.setCharacterEncoding("utf-8");

        if (null == session) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        if (path.indexOf("cis") > 0 || path.indexOf("login") > 0 || path.endsWith("js") || path.indexOf(".png") > 0
            || path.indexOf("LoginServlet") > 0 || path.indexOf(".css") > 0 || path.contains("ContentServlet")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        Userbean loginUser = (Userbean) session.getAttribute("user");
        if (null == loginUser) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } else {
            chain.doFilter(request, response);
        }

    }

}
