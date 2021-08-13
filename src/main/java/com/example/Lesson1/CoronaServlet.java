package com.example.Lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author antonkuznetsov
 */
@WebServlet(name = "CoronaServlet", urlPatterns = {"/corona"})
public class CoronaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String temperature = req.getParameter("temperature");

        if (name == null || temperature == null) {
            resp.sendError(400,"name and temperature is missing");
            return;
        }

        final int temperatureInt = Integer.parseInt(temperature);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        if (temperatureInt > 39) {
            resp.getWriter().write("<h1>Вы больны</h1>");
        } else {
            resp.getWriter().write("<h1>Вы здоровы</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Use get please");
    }
}
