package com.lab.web.Servlets;

import com.lab.web.DTO.Coordinates;
import com.lab.web.DTO.HitRow;
import com.lab.web.util.Validator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("controller get");
        String path = "/error";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("controller post");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        boolean forward = true;
        if (request.getParameter("context")!=null && request.getParameter("context").equals("clean")){
            getServletContext().setAttribute("data", new ArrayList<HitRow>());
           forward = false;
        }
        if (forward) {
            try {
                double xValue = Validator.validateX(request.getParameter("X_val"));
                double yValue = Validator.validateY(request.getParameter("Y_val"));
                double rValue = Validator.validateR(request.getParameter("R_val"));
                Coordinates coordinates = new Coordinates(xValue, yValue, rValue);
                request.setAttribute("coordinates", coordinates);

                String path = "/area-check";
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }
            catch (Exception e){
                String path = "/error";
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }
        }
    }

}
