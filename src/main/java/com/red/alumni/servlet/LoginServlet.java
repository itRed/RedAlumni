package com.red.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.red.alumni.bean.Userbean;
import com.red.alumni.util.ConnUtils;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 6666344391160176988L;

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * This method is called when a form has its tag value method equals to get.
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * This method is called when a form has its tag value method equals to
     * post.
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String sql = "SELECT USER_ID,USER_NAME,USER_ALIAS,USER_PWD,USER_EMAIL,USER_BIRTH,USER_HOME,USER_PLACE,USER_PHONE,USER_QQ,USER_MOTTO,USER_ROLEID,USER_STATUSID,USER_USER_PERMISSION FROM alumni.userinfo WHERE USER_NAME='"
                     + username + "'";
        Connection conn = ConnUtils.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        Userbean user = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = new Userbean(rs.getInt("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_ALIAS"), rs
                    .getString("USER_PWD"), rs.getString("USER_EMAIL"), rs.getString("USER_BIRTH"), rs
                    .getString("USER_HOME"), rs.getString("USER_PLACE"), rs.getString("USER_PHONE"), rs
                    .getString("USER_QQ"), rs.getString("USER_MOTTO"), rs.getInt("USER_ROLEID"), rs
                    .getInt("USER_STATUSID"), rs.getInt("USER_USER_PERMISSION"));

            }
            if (null == user) {
                out.write("0");// 非系统用户
            } else {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("username", user.getUser_name());
                request.getSession().setAttribute("userid", user.getUser_id() + "");
                request.getSession().setMaxInactiveInterval(20 * 60);
                if (user.getUser_roleid() == 3 && user.getUser_statusid() != 2) {// 老师
                    out.write("3");
                } else if (user.getUser_roleid() == 2 && user.getUser_statusid() != 2) {// 同学
                    out.write("2");
                } else if (user.getUser_roleid() == 1) {// 管理员
                    out.write("1");
                }
            }
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtils.closeConn(rs, stmt, conn);
        }
    }

    /**
     * Initialization of the servlet. <br>
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
