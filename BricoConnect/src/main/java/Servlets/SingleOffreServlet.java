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

@WebServlet("/offre")
public class SingleOffreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'identifiant de l'offre à afficher depuis les paramètres de la requête
        int idOffre = Integer.parseInt(request.getParameter("id"));

        OffreDaoImpl offreDao = new OffreDaoImpl();

        try {
            // Récupérer l'offre de projet correspondant à l'identifiant spécifié
            OffreDeProjet offre = offreDao.get(idOffre);

            // Passer l'offre de projet à la JSP pour l'affichage
            request.setAttribute("offre", offre);

            // Redirection vers la JSP qui affiche une seule offre de projet
            request.getRequestDispatcher("/WEB-INF/Views/Single_Offre.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Redirection vers une page d'erreur en cas d'erreur SQL
        }
    }
}
