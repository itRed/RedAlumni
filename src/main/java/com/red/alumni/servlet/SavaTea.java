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
import javax.transaction.Transaction;

import com.red.alumni.util.ConnUtils;
import com.red.alumni.util.DateUtil;
import com.red.alumni.util.HtmlUtils;

public class SavaTea extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -2776819954739928691L;

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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
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
        String uname = request.getParameter("uname");
        String uid = request.getParameter("uid");
        String uemail = request.getParameter("uemail");
        String uphone = request.getParameter("uphone");
        String uqq = request.getParameter("uqq");
        String umotto = request.getParameter("umotto");
        String alumnitext = request.getParameter("alumnitext");

        System.out.println(uid + "===uid");
        Connection conn = ConnUtils.getConnection();
        Statement stmt = null;
        String sql = "UPDATE alumni.userinfo SET USER_NAME = '" + uname + "',USER_EMAIL = '" + uemail
                     + "',USER_PHONE = '" + uphone + "',USER_QQ = '" + uqq + "',USER_MOTTO = '" + umotto
                     + "',USER_ROLEID = '3',USER_STATUSID = '2' WHERE USER_NAME='" + uname + "'";
        String sql1 = "INSERT INTO alumni.contentinfo(CONTENT_TITLE,CONTENT_DETAIL,CONTENT_DATE,CONTENT_USERID) VALUES ('"
                      + HtmlUtils.delHTMLTag(alumnitext)
                      + "','"
                      + alumnitext
                      + "','"
                      + DateUtil.getUnixTimestamp()
                      + "','" + uid + "')";
        int a = 0;
        int b = 0;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            a = stmt.executeUpdate(sql);
            b = stmt.executeUpdate(sql1);
            conn.commit();
            System.out.println(a + "=a");
            System.out.println(b + "=b");

            if (a != 0 && b != 0) {
                response.sendRedirect("teadeal.jsp?uid=" + uid);
            } else {
                response.sendRedirect("teainfo.jsp");
            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            ConnUtils.closeUConn(stmt, conn);
        }

        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
