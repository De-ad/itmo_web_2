package com.lab.web.Servlets;

import com.lab.web.DTO.Coordinates;
import com.lab.web.DTO.HitRow;
import com.lab.web.util.Checker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;


@WebServlet(name = "AreaCheckServlet", value = "/area-check")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("area check get");
        String path = "/error";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("area check post");
            long endTime = System.currentTimeMillis();
            long startTime = (Long) request.getAttribute("startTime");
            long executionTime = (endTime - startTime);

            HitRow hitRow = new HitRow();
            hitRow.setCurrentTime(LocalDateTime.now());
            Checker checker = new Checker();

            hitRow.setExecutionTime(executionTime);
            Coordinates coordinates = (Coordinates) request.getAttribute("coordinates");
            hitRow.setR(coordinates.getR());
            hitRow.setX(coordinates.getX());
            hitRow.setY(coordinates.getY());
            hitRow.setResult(checker.check(hitRow.getX(), hitRow.getY(), hitRow.getR()));

            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.print(hitRow.convertToJson());
            ServletContext servletContext = getServletContext();
            if (servletContext.getAttribute("data") == null) {
                    servletContext.setAttribute("data", new ArrayList<HitRow>());
             }
            ArrayList<HitRow> hitRows = (ArrayList<HitRow>) servletContext.getAttribute("data");
            hitRows.add(hitRow);
            servletContext.setAttribute("data", hitRows);
            writer.close();
    }
}
