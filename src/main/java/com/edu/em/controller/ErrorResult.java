package com.edu.em.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/error")
public class ErrorResult extends HttpServlet {

    private final String[] choices = new String[]{"Да! Переголосую!",
            "Тоже Да, но \"нехотя\"!!"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("choiceList", choices);
        req.getRequestDispatcher("/WEB-INF/template/error.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String[] choices = req.getParameterValues("choice");
        if (choices != null) {
            resp.sendRedirect(req.getContextPath() + "/vote");
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
