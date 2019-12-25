package com.zelin.pojo;
import	java.sql.Statement;
import	java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import	java.util.Properties;

import java.util.Properties;

public class JdbcUtils {
    private static Properties db;
    private static String driver;
    private static String user;
    private static String url;
    private static String password;

    public JdbcUtils() {
    }

    public  Properties getDb() {
        return db;
    }

    public  void setDb(Properties db) {
        JdbcUtils.db = db;
    }
    public static Connection getConnection() {
        try {
            driver = db.getProperty("driver");
            url = db.getProperty("url");
            user = db.getProperty("user");
            password = db.getProperty("password");
            Class.forName(driver);
            return DriverManager.getConnection(url,user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(ResultSet rs,Statement st,Connection con){
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(st!=null) {
                    st.close();
                }
                if(con!=null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
