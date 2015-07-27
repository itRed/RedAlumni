package com.red.alumni.servlet;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.red.alumni.bean.Contentbean;
import com.red.alumni.bean.Userbean;
import com.red.alumni.pdf.Pdf;
import com.red.alumni.pdf.cell.Component;
import com.red.alumni.pdf.cell.Label;
import com.red.alumni.pdf.cell.PdfImage;
import com.red.alumni.pdf.cell.Table;
import com.red.alumni.pdf.style.StyleConst;
import com.red.alumni.util.DataUtil;
import com.red.alumni.util.DateUtil;

public class DealReportServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 8310753159779411943L;

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
        int uid = Integer.parseInt(request.getParameter("uid"));
        List<Component> list = new ArrayList<Component>();
        response.setHeader("Content-Type", "application/pdf");
        String abspath = request.getServerName();
        String port = String.valueOf(request.getServerPort());
        try {
            Userbean user = DataUtil.getUser(uid);
            Contentbean content = DataUtil.getContent(uid);

            /**
             * 分割条
             */
            Label spe = new Label("", StyleConst.BIGTITLE, new Color(75, 152, 188));
            /**
             * 减免栏高度
             */
            float freeheight = 0;
            spe.setBeforeSpace(10);

            String realpath = request.getSession().getServletContext().getRealPath("/") + "images/pdflogo.jpg";
            list.add(new PdfImage(realpath));

            list.add(spe);
            Label label0 = new Label("大  名：", StyleConst.ALIGN_LEFT);
            Label label1 = new Label(user.getUser_name(), StyleConst.ALIGN_LEFT);
            Label label2 = new Label("绰  号：", StyleConst.ALIGN_LEFT);
            Label label3 = new Label(user.getUser_alias(), StyleConst.ALIGN_LEFT);
            Label label4 = new Label("邮  箱：", StyleConst.ALIGN_LEFT);
            Label label5 = new Label(user.getUser_email(), StyleConst.ALIGN_LEFT);
            Label label6 = new Label("破蛋日期：", StyleConst.ALIGN_LEFT);
            Label label7 = new Label(user.getUser_birth(), StyleConst.ALIGN_LEFT);
            Label label8 = new Label("我的家乡：", StyleConst.ALIGN_LEFT);
            Label label9 = new Label(user.getUser_home().replace("-", ""), StyleConst.ALIGN_LEFT);
            Label label10 = new Label("工作城市：", StyleConst.ALIGN_LEFT);
            Label label11 = new Label(user.getUser_place().replace("-", ""), StyleConst.ALIGN_LEFT);
            Label label12 = new Label("联系电话：", StyleConst.ALIGN_LEFT);
            Label label13 = new Label(user.getUser_phone(), StyleConst.ALIGN_LEFT);
            Label label14 = new Label("联系QQ：", StyleConst.ALIGN_LEFT);
            Label label15 = new Label(user.getUser_qq(), StyleConst.ALIGN_LEFT);

            Label[][] contents = new Label[4][4];
            contents[0][0] = label0;
            contents[0][1] = label1;
            contents[0][2] = label2;
            contents[0][3] = label3;
            contents[1][0] = label4;
            contents[1][1] = label5;
            contents[1][2] = label6;
            contents[1][3] = label7;
            contents[2][0] = label8;
            contents[2][1] = label9;
            contents[2][2] = label10;
            contents[2][3] = label11;
            contents[3][0] = label12;
            contents[3][1] = label13;
            contents[3][2] = label14;
            contents[3][3] = label15;

            Table table = new Table(4, new Label("风雨同在", StyleConst.COMMONTITLE), contents, 0);
            list.add(table);

            list.add(new Label("座右铭：", StyleConst.ALIGN_LEFT));
            list.add(new Label("        "+user.getUser_motto(), StyleConst.ALIGN_LEFT));
            list.add(spe);

            Label[][] contents3 = new Label[1][1];
            contents3[0][0] = new Label(content.getContent_title(),StyleConst.ALIGN_LEFT);
            Table table3 = new Table(1, new Label("铭记有我", StyleConst.COMMONTITLE), contents3, 0);
            list.add(table3);

            list.add(new Label("完成时间："
                               + DateUtil.fromUnixtime(Integer.parseInt(content.getContent_date()),
                                                       "yyyy-MM-dd HH:mm:ss"), StyleConst.ALIGN_RIGHT));

            list.add(spe);
            list.add(spe);
            list.add(new Label("技术支持：Red(it_red@sina.com)", StyleConst.ALIGN_LEFT));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Label[][] contentfoot = new Label[2][2];
            contentfoot[0][1] = new Label("Red 出品");
            contentfoot[1][1] = new Label("导出日期：" + sdf.format(new Date()));
            Table tablefoot = new Table(2, new Label("", null, StyleConst.ALIGN_RIGHT), contentfoot, 0);
            tablefoot.setBeforeSpace(50);
            list.add(tablefoot);
            
            String foot= request.getSession().getServletContext().getRealPath("/") + "images/pdffoot.jpg";
            list.add(new PdfImage(foot));
            
            Pdf.build(list, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
