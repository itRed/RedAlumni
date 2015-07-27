package com.red.alumni.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.red.alumni.bean.Contentbean;
import com.red.alumni.bean.Userbean;

public class DataUtil {

    public static Userbean getUser(int uid) {
        Userbean user = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnUtils.getConnection();
            String sql = "SELECT USER_ID,USER_NAME,USER_ALIAS,USER_PWD,USER_EMAIL,USER_BIRTH,USER_HOME,USER_PLACE,USER_PHONE,USER_QQ,USER_MOTTO,USER_ROLEID,USER_STATUSID,USER_USER_PERMISSION FROM alumni.userinfo WHERE USER_ID='"
                         + uid + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = new Userbean(rs.getInt("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_ALIAS"), rs
                    .getString("USER_PWD"), rs.getString("USER_EMAIL"), rs.getString("USER_BIRTH"), rs
                    .getString("USER_HOME"), rs.getString("USER_PLACE"), rs.getString("USER_PHONE"), rs
                    .getString("USER_QQ"), rs.getString("USER_MOTTO"), rs.getInt("USER_ROLEID"), rs
                    .getInt("USER_STATUSID"), rs.getInt("USER_USER_PERMISSION"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtils.closeConn(rs, stmt, conn);
        }
        return user;
    }

    public static Contentbean getContent(int uid) {
        Contentbean content = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnUtils.getConnection();
            String sql = "SELECT CONTENT_ID,CONTENT_TITLE,CONTENT_DETAIL,CONTENT_DATE,CONTENT_USERID FROM alumni.contentinfo WHERE CONTENT_USERID='"
                         + uid + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                content = new Contentbean(rs.getInt("CONTENT_ID"), rs.getString("CONTENT_TITLE"), rs
                    .getString("CONTENT_DETAIL"), rs.getString("CONTENT_DATE"), rs.getInt("CONTENT_USERID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtils.closeConn(rs, stmt, conn);
        }
        return content;
    }
}
