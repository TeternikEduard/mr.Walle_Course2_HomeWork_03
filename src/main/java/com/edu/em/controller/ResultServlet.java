package com.edu.em.controller;
import com.edu.em.dto.Stats;
import com.edu.em.service.VoteService;
import com.edu.em.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {


    private final IVoteService service = new VoteService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Stats stats = service.getStats();

        req.setAttribute("artist", stats.getArtists());
        req.setAttribute("genres", stats.getGenre());
        req.setAttribute("abouts", stats.getAbouts().toArray());

        req.getRequestDispatcher("/WEB-INF/template/result.jsp").forward(req, resp);
    }
}

