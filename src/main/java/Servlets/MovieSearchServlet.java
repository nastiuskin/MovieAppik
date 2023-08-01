package Servlets;
import DataAccessObjects.MovieDAO;
import Entities.Movie;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/movie-search")
public class MovieSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieName = request.getParameter("movieName");
        Movie movie = MovieDAO.getMovieByName(movieName);
//        Movie movie1 = new Movie("title","en","bjkgbg","movie", new String[]{"1", "5"}, 6.7, "1233", "hfhgn" );
        request.setAttribute("movie", movie);
        request.getRequestDispatcher("/movie-info.jsp").forward(request, response);
    }


}