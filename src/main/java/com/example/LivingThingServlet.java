package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LivingThingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String livingThing = request.getParameter("livingThing");
        request.setAttribute("livingThing", livingThing);
        request.getRequestDispatcher("livingThing.jsp").forward(request, response);
    }
}
