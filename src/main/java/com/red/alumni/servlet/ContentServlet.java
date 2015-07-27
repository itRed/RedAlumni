package com.red.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.red.alumni.bean.Userbean;
import com.red.alumni.util.ConnUtils;
import com.red.alumni.util.DateUtil;

public class ContentServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -8045214243790175438L;

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
        System.out.println("DOGET");
//        doPost(request, response);
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
        String title = request.getParameter("content");
        String content = request.getParameter("contentinfo");
        int userid = Integer.parseInt(request.getParameter("uid"));
        Connection conn = ConnUtils.getConnection();
        Statement stmt = null;
        String sql = "INSERT INTO alumni.contentinfo(CONTENT_TITLE,CONTENT_DETAIL,CONTENT_DATE,CONTENT_USERID) VALUES ('"
                     + title + "','" + content + "','" + DateUtil.getUnixTimestamp() + "','" + userid + "')";
        try {
            stmt = conn.createStatement();
            int result= stmt.executeUpdate(sql);
            if (result>0) {
                out.write("1");
            } else {
                out.write("0");
            }
        } catch (Exception e) {
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
