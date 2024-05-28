package DAO.Projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;


public class ProjetDaoImpl implements ProjetDaoInterface{

	@Override
	public Projet get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM projet WHERE 	Id_projet = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToProjet(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<Projet> getAll() throws SQLException {
		List<Projet> projets = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM projet")) {

            while (resultSet.next()) {
                projets.add(mapResultSetToProjet(resultSet));
            }
        }

        return projets;
	}

	@Override
	public int insert(Projet projet) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO projet (EtatAvancementArtisan, EtatAvancementEmployeur, NoteArtisan, NoteEmployeur, Id_postulation) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setProjetParameters(statement, projet);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
	}

	@Override
	public int update(Projet projet) throws SQLException {
		 try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE projet SET EtatAvancementArtisan = ?, EtatAvancementEmployeur = ?, NoteArtisan = ?, NoteEmployeur = ?, Id_postulation = ?  WHERE id_projet = ?"))
		 {

	            setProjetParameters(statement, projet);
	            statement.setInt(13, projet.getId_projet());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(Projet t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 private void setProjetParameters(PreparedStatement statement, Projet projet) throws SQLException {
	    	statement.setString(1, projet.getEtatAvancementArtisan());
	        statement.setString(2, projet.getEtatAvancementEmployeur());
	        statement.setFloat(3, projet.getNoteArtisan());
	        statement.setFloat(4, projet.getNoteEmployeur());
	        statement.setInt(5, projet.getId_postulation());
	      
			
		}

		private Projet mapResultSetToProjet(ResultSet resultSet) throws SQLException {
	        return new Projet(
	        		resultSet.getInt("id_projet"),
	                resultSet.getString("EtatAvancementArtisan"),
	                resultSet.getString("EtatAvancementEmployeur"),
	                resultSet.getFloat("NoteArtisan"),
	                resultSet.getFloat("NoteEmployeur"),
	                resultSet.getInt("Id_postulation")
	              

	        );
	    }
	
	
		
}
