package com.red.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitSystem extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public ExitSystem() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 清理session
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("username");
        // 跳转登录界面
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                          + request.getContextPath() + "/login.jsp";
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">top.location.href = '" + basePath + "';</script>");
        out.flush();
        out.close();
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
