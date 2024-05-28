package Servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Homeartisan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Effectuer des opérations nécessaires avant la redirection, si nécessaire.

        // Récupérer le Dispatcher
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/View/Home_artisan.jsp");

        // Utiliser forward pour rediriger vers la page JSP
        dispatcher.forward(request, response);
    }
}
