package com.red.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.red.alumni.bean.Userbean;
import com.red.alumni.util.ConnUtils;

public class SavestuinfoServlet extends HttpServlet {

    private static final long serialVersionUID = 5963024697810911571L;

    /**
     * Destruction of the servlet. <br>
     */
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
        int usesrid = Integer.parseInt(request.getSession().getAttribute("userid") + "");
        String userName = request.getSession().getAttribute("username") + "";
        String userAlias = request.getParameter("useralias");
        String userPwd = request.getParameter("password");
        String userEmail = request.getParameter("useremail");
        String userBirth = request.getParameter("userbirth");
        String userHome = request.getParameter("userhome");
        String userPlace = request.getParameter("userwork");
        String userPhone = request.getParameter("userphone");
        String userQq = request.getParameter("userqq");
        String userMotto = request.getParameter("usermotto");
        Connection conn = ConnUtils.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        Userbean user = null;
        try {
            user = new Userbean(usesrid, userName, userAlias, userPwd, userEmail, userBirth, userHome, userPlace,
                                userPhone, userQq, userMotto, 2, 2, 0);
            String sqll = "UPDATE alumni.userinfo SET USER_ID = '" + user.getUser_id() + "',USER_NAME = '"
                          + user.getUser_name() + "',USER_ALIAS = '" + user.getUser_alias() + "',USER_PWD = '"
                          + user.getUser_pwd() + "',USER_EMAIL = '" + user.getUser_email() + "',USER_BIRTH = '"
                          + user.getUser_birth() + "',USER_HOME = '" + user.getUser_home() + "',USER_PLACE = '"
                          + user.getUser_place() + "',USER_PHONE = '" + user.getUser_phone() + "',USER_QQ = '"
                          + user.getUser_qq() + "',USER_MOTTO = '" + user.getUser_motto() + "',USER_ROLEID = '"
                          + user.getUser_roleid() + "',USER_STATUSID = '" + user.getUser_statusid()
                          + "',USER_USER_PERMISSION = '" + user.getUser_user_permission() + "' WHERE USER_ID = '"
                          + user.getUser_id() + "';";
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sqll);
            request.getSession().setAttribute("username", user.getUser_name());
            if (a > 0) {
                String param="uid="+user.getUser_id()+"&uname="+user.getUser_name()+"&d="+new Date().getTime();
                response.sendRedirect("stucontent.jsp?"+param);
            } else {
                response.sendRedirect("stuinfo.jsp");
            }
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
