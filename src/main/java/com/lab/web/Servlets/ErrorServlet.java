package com.lab.web.Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ErrorServlet", value = "/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>");
        writer.println("You shall not pass...\n");
        writer.println("Welcome to the error page. Error 404, I guess...");
        writer.println("</h1>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>");
        writer.println("You shall not pass...\n");
        writer.println("Welcome to error page. Error 404, I guess...");
        writer.println("</h1>");
        writer.close();
    }
}
