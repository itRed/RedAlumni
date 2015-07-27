package com.red.alumni.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnUtils {

    public static Connection getConnection() {
        String Driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/alumni";
        String user = "root";
        String password = "123456";
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (null != rs && !rs.isClosed()) rs.close();
            if (null != stmt && !stmt.isClosed()) stmt.close();
            if (null != conn && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeUConn(Statement stmt, Connection conn) {
        try {
            if (null != stmt && !stmt.isClosed()) stmt.close();
            if (null != conn && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
