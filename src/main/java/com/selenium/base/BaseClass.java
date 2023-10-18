package com.selenium.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection con;
    @BeforeMethod
    public Connection setup() throws SQLException {
     String dburl="jdbc:mysql://localhost:3306/student";
     String Username="root";
     String Password="asish";
     con= DriverManager.getConnection(dburl,Username,Password);
     return con;
    }
    @AfterMethod
    public void end() throws SQLException {
        con.close();
    }
}
