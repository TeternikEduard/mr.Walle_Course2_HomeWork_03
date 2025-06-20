package com.edu.em.controller;

import com.edu.em.dto.Vote;
import com.edu.em.service.VoteService;
import com.edu.em.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final IVoteService service = new VoteService();


    private final String[] artists = new String[]{"LinkinPark",
            "Dead by Sunrise", "Grey Daze"};
    private final String[] genres = new String[]{"альтернативный рок",
            "ню-метал", "альтернативный метал", "электроник-рок", "постгранж",
            "хард-рок", "поп-рок", "rock", "панк-рок", "хэви-металл"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artistsList", artists);
        req.setAttribute("genresList", genres);

        req.getRequestDispatcher("/WEB-INF/template/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] artists = req.getParameterValues("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");


        Vote result = new Vote();
        result.setDtCreate(LocalDateTime.now());
        result.setArtist(artists[0]);
        result.setGenres(Arrays.asList(genres));
        result.setAbout(about);
        service.add(result);


        resp.sendRedirect(req.getContextPath() + "/result");

    }
}