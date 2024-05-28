package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import DAO.Artisan.Artisan;
import DAO.Artisan.ArtisanDaoImpl;
import DAO.Employeur.Employeur;
import DAO.Employeur.EmployeurDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Affichage du formulaire de login (login.jsp)
        request.getRequestDispatcher("WEB-INF/Views/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Email = request.getParameter("email");
        String MotDePasse = request.getParameter("password");
        String userType = request.getParameter("userType"); // Ajoutez un champ caché dans votre formulaire pour identifier le type d'utilisateur

        if ("artisan".equals(userType)) {
            handleArtisanLogin(Email, MotDePasse, request, response);
        } else if ("employeur".equals(userType)) {
            handleEmployeurLogin(Email, MotDePasse, request, response);
        } else {
            // Gérer le cas où le type d'utilisateur n'est pas spécifié correctement
            response.sendRedirect("/hhhhhhhhh.jsp");
        }
    }

    private void handleArtisanLogin(String email, String password, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ArtisanDaoImpl artisanDao = new ArtisanDaoImpl();

        try {
            int artisan = artisanDao.authenticate(email, password);

            if (artisan != -1) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("userType", "artisan");
                session.setAttribute("userId", artisan);
                // Identifiants corrects, rediriger vers la page d'accueil de l'artisan
                response.sendRedirect("Home_artisan");
                /**System.out.println(session.getAttribute("userType"));
                System.out.println(session.getAttribute("userId")); **/
            } else {
                // Identifiants incorrects, rediriger vers une page d'erreur ou de connexion
                response.sendRedirect("/LoginServlet");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs liées à la base de données
            response.sendRedirect("/error.jsp");
        }
    }

    private void handleEmployeurLogin(String Email, String MotDePasse, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        EmployeurDaoImpl employeurDao = new EmployeurDaoImpl();

        try {
            Employeur employeur = employeurDao.authenticate(Email, MotDePasse);

            if (employeur != null) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("userType", "employeur");
                session.setAttribute("userId", employeur.getId_employeur());
                
                // Identifiants corrects, rediriger vers la page d'accueil de l'employeur
                response.sendRedirect("Home_artisan");
            } else {
                // Identifiants incorrects, rediriger vers une page d'erreur ou de connexion
                response.sendRedirect("/resultSet");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs liées à la base de données
            response.sendRedirect("/errojjjjjjr.jsp");
        }
    }
}
