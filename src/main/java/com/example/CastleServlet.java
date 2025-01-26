package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.util.List;

public class CastleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        List<String> animals = AnimalStorage.loadAnimals();
        getServletContext().setAttribute("animals", animals);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> animals = (List<String>) getServletContext().getAttribute("animals");

        request.setAttribute("defaultAnimals", List.of(
                new Animal("cat", "The cat likes to sleep and purr.", "https://i.imgur.com/Uschheg.jpeg"),
                new Animal("dog", "The dog likes to play and defend the castle.", "https://i.imgur.com/XgbZdeA.jpeg"),
                new Animal("dragon", "A dragon guards the castle from the sky.", "https://i.imgur.com/Uc4x1Y6.jpeg")
        ));

        request.setAttribute("animals", animals);
        request.getRequestDispatcher("/castle.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String animal = request.getParameter("animal");
        String user = (String) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/castle-1.0/login");
            return;
        }
        synchronized (getServletContext()) {
            List<String> animals = (List<String>) getServletContext().getAttribute("animals");

            if ("add".equals(action) && animal != null && !animal.trim().isEmpty()) {
                animals.add(animal);
                logUserAction("Added animal: " + animal, animals.size());
            } else if ("remove".equals(action) && animal != null) {
                animals.remove(animal);
                logUserAction("Removed animal: " + animal, animals.size());
            }

            AnimalStorage.saveAnimals(animals);
        }

        response.sendRedirect("castle");
    }

    /**
     * Те самые логи действий. Да - да.
     */
    private void logUserAction(String action, int totalAnimals) {
        try (FileWriter writer = new FileWriter("user-actions.log", true)) {
            writer.write(action + " | Total animals: " + totalAnimals + " | " + new java.util.Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

