package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.Artisan.Artisan;
import DAO.Postulation.Postulation;
import DAO.Postulation.PostulationDaoImpl;

@WebServlet("/postuler")
public class PostulationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int userId = (int) session.getAttribute("userId");

        // Récupérer les paramètres du formulaire
        int idOffre = Integer.parseInt(request.getParameter("id"));
        float montant = Float.parseFloat(request.getParameter("montant"));
        String message = request.getParameter("message");

        // Créer un objet Postulation
        Postulation postulation = new Postulation();
        postulation.setMontant(montant);
        postulation.setMessage(message);
        postulation.setId_artisan(userId);
        postulation.setId_offre(idOffre);
    	System.out.println(montant);

    	System.out.println(message);

    	System.out.println(userId);
    	System.out.println(idOffre);


        // Insérer la postulation dans la base de données
        PostulationDaoImpl postulationDao = new PostulationDaoImpl();
        try {
            int rowsAffected = postulationDao.insert(montant,message, userId,idOffre);
            if (rowsAffected > 0) {
                // La postulation a été ajoutée avec succès
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // La postulation n'a pas pu être ajoutée
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs SQL
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
