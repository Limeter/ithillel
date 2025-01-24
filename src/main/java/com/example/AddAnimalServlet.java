package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String animal = request.getParameter("animal");

        if (animal != null && !animal.isEmpty()) {
            synchronized (getServletContext()) {
                List<String> animals = (List<String>) getServletContext().getAttribute("animals");
                if (animals == null) {
                    animals = new ArrayList<>();
                }
                animals.add(animal);
                getServletContext().setAttribute("animals", animals);
            }
        }

        request.setAttribute("animals", getServletContext().getAttribute("animals"));
        request.getRequestDispatcher("/addAnimal.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("animals", getServletContext().getAttribute("animals"));
        request.getRequestDispatcher("/addAnimal.jsp").forward(request, response);
    }
}
