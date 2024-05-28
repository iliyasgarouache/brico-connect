package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.OffreDeProjet.OffreDaoImpl;
import DAO.OffreDeProjet.OffreDeProjet;

@WebServlet("/allOffers")
public class AllOffersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Utiliser OffreDaoImpl pour récupérer toutes les offres de projet
            OffreDaoImpl offreDao = new OffreDaoImpl();
            List<OffreDeProjet> offres = offreDao.getAll();


            // Passer la liste des offres à la JSP
            request.setAttribute("offres", offres);
            System.out.println(offres);


            // Rediriger vers la page JSP qui affichera les offres
            request.getRequestDispatcher("/WEB-INF/views/allOffers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }
}
