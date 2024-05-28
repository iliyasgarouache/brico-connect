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
import DAO.Artisan.ArtisanDaoImpl;

@WebServlet("/profile")
public class ProfileArtisanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        int userId = (int) session.getAttribute("userId");

        if ("artisan".equals(userType)) {
            showArtisanProfile(userId, request, response);
        } else {
            // Gérer le cas où le type d'utilisateur n'est pas "artisan"
        	System.out.println("machi artisan");
        }
    }

    private void showArtisanProfile(int artisanId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtisanDaoImpl artisanDao = new ArtisanDaoImpl();

        try {
            Artisan artisan = artisanDao.get(artisanId);

            if (artisan != null) {
                // Passer les informations de l'artisan à la JSP
                request.setAttribute("artisan", artisan);
                
                // Redirection vers la page de profil de l'artisan
                request.getRequestDispatcher("/WEB-INF/Views/Profile_artisan.jsp").forward(request, response);
            } else {
                // Gérer le cas où l'artisan n'est pas trouvé
                response.sendRedirect("/error.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        int userId = (int) session.getAttribute("userId");

        if ("artisan".equals(userType)) {
            updateArtisanProfile(userId, request, response);
        } else {
            // Gérer le cas où le type d'utilisateur n'est pas "artisan"
            response.sendRedirect("/error.jsp");
        }
    }

    private void updateArtisanProfile(int artisanId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtisanDaoImpl artisanDao = new ArtisanDaoImpl();

        // Récupérer les nouvelles informations depuis le formulaire
        String Nom = request.getParameter("Nom");
        String Prenom = request.getParameter("Prenom");
        String Email = request.getParameter("Email");
        String CIN = request.getParameter("CIN");
        String Langues = "chel7a";
        String adresse = request.getParameter("Adresse");
        String Formation = request.getParameter("Formation");
        String Competences = request.getParameter("Competences");
        String ExperienceProfessionnelle = request.getParameter("ExperienceProfessionnelle");
        HttpSession session = request.getSession();
        int id_artisan = (int) session.getAttribute("userId");

        Artisan updatedArtisan = new Artisan(Nom, Prenom, Email, CIN, adresse, Langues, Formation,
                ExperienceProfessionnelle, Competences, id_artisan);

        try {
            artisanDao.update(Nom, Prenom, Email, CIN, adresse, Langues, Formation,
                    ExperienceProfessionnelle, Competences,id_artisan);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(Nom);
        System.out.println(Prenom);
        System.out.println(Email);
        System.out.println(CIN);
        System.out.println(Langues);
        System.out.println(adresse);
        System.out.println(Formation);
        System.out.println(Competences);
        System.out.println(ExperienceProfessionnelle);
        System.out.println(id_artisan);

       
        
        
        // Redirection vers la page de profil après la mise à jour
        response.sendRedirect("profile");
    }



	
}
