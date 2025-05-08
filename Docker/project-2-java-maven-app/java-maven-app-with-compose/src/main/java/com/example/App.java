package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbtest")
public class App extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://mysql:3306/testdb";
        String username = "user";
        String password = "password";
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            out.println("<h1>Database connection successful!</h1>");
            conn.close();
        } catch (SQLException e) {
            response.getWriter().println("<h1>Database connection failed:</h1><pre>" + e + "</pre>");
        }
    }
}