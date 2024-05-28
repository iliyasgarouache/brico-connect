package DAO.Employeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;


public class EmployeurDaoImpl implements EmployeurDaoInterface {

	@Override
	public Employeur get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeur WHERE 	Id_employeur = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToEmployeur(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<Employeur> getAll() throws SQLException {
		List<Employeur> employeurs = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employeur")) {

            while (resultSet.next()) {
                employeurs.add(mapResultSetToEmployeur(resultSet));
            }
        }

        return employeurs;
	}

	@Override
	public int insert(Employeur employeur) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO artisan (Nom, Prenom, Email, MotDePasse, CIN,NumeroDeTelephone, NoteGlobArtisan, adresse, Statut) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setEmployeurParameters(statement, employeur);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
		
	}

	@Override
	public int update(Employeur employeur) throws SQLException {
		 try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE employeur SET Nom = ?, Prenom = ?, Email = ?, MotDePasse = ?, CIN = ?, NumeroDeTelephone = ?, NoteGlobEmployeur = ?, adresse = ?, Statut= ?  WHERE id_employeur = ?"))
		 {

	            setEmployeurParameters(statement, employeur);
	            statement.setInt(13, employeur.getId_employeur());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(Employeur t) {
		// TODO Auto-generated method stub
		return 0;
	}
	  private void setEmployeurParameters(PreparedStatement statement, Employeur employeur) throws SQLException {
	    	statement.setString(1, employeur.getNom());
	        statement.setString(2, employeur.getPrenom());
	        statement.setString(3, employeur.getEmail());
	        statement.setString(4, employeur.getMotDePasse());
	        statement.setString(5, employeur.getCIN());
	        statement.setInt(6, employeur.getNumeroDeTelephone());
	        statement.setFloat(7, employeur.getNoteGlobEmployeur());
	        statement.setString(8, employeur.getAdresse());
	        statement.setString(9, employeur.getStatut());
			
		}

		private Employeur mapResultSetToEmployeur(ResultSet resultSet) throws SQLException {
	        return new Employeur(
	        		resultSet.getInt("id_employeur"),
	                resultSet.getString("Nom"),
	                resultSet.getString("Prenom"),
	                resultSet.getString("Email"),
	                resultSet.getString("MotDePasse"),
	                resultSet.getString("CIN"),
	                resultSet.getInt("NumeroDeTelephone"),
	                resultSet.getFloat("NoteGlobEmployeur"),
	                resultSet.getString("adresse"),
	                resultSet.getString("Statut")

	        );
	    }
		public Employeur authenticate(String Email, String MotDePasse) throws SQLException {
	        try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeur WHERE Email = ? AND MotDePasse = ?")) {

	            statement.setString(1, Email);
	            statement.setString(2, MotDePasse);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToEmployeur(resultSet);
	                }
	            }
	        }

	        return null;
	    }

}
