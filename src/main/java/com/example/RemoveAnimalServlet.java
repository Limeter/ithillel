package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoveAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String animalToRemove = request.getParameter("animal");
        if (animalToRemove != null && !animalToRemove.isEmpty()) {
            synchronized (getServletContext()) {
                List<String> animals = (List<String>) getServletContext().getAttribute("animals");
                if (animals != null && animals.contains(animalToRemove)) {
                    animals.remove(animalToRemove);
                    getServletContext().setAttribute("animals", animals);
                    AnimalStorage.saveAnimals(animals);
                }
            }
        }
        response.sendRedirect("addAnimal");
    }
}

