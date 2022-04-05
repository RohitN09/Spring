package com.worker.util;

import java.sql.*;

public class DBConnection {
	
    static final String url = "jdbc:mysql://localhost:3307/my_org";
    static final String username = "root";
    static final String password = "root";
    private static Connection con = null;

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database server "
                    + con.getMetaData().getDatabaseProductName()
                    + " version: "
                    + con.getMetaData().getDatabaseProductVersion());
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}