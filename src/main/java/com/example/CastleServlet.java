package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
public class CastleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String livingThing = request.getParameter("livingThing");

        // Загружаем список животных из файла
        List<String> animals = AnimalStorage.loadAnimals();
        request.setAttribute("animals", animals);  // передаем animals в JSP

        if (livingThing != null) {
            request.setAttribute("livingThing", livingThing);
            request.getRequestDispatcher("/livingThing.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/castle.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newAnimal = request.getParameter("animal");
        if (newAnimal != null && !newAnimal.trim().isEmpty()) {
            // Загружаем текущий список животных
            List<String> animals = AnimalStorage.loadAnimals();
            animals.add(newAnimal);  // добавляем новое животное

            // Сохраняем обновленный список животных в файл
            AnimalStorage.saveAnimals(animals);
        }

        response.sendRedirect("/castle-1.0/castle");  // перезагружаем страницу с замком
    }
}

