package com.luv2code.testdb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String username = "springstudent";
        String password = "springstudent";


        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, username, password);

            out.println("Connection successful!!!");

            myConn.close();

        }
        catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
