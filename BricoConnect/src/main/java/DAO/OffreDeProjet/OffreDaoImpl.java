package DAO.OffreDeProjet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;


public class OffreDaoImpl implements OffreDaoInterface {

	@Override
	public OffreDeProjet get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM offredeprojet WHERE 	Id_offre = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToOffre(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<OffreDeProjet> getAll() throws SQLException {
		List<OffreDeProjet> offres = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM offredeprojet")) {

            while (resultSet.next()) {
                offres.add(mapResultSetToOffre(resultSet));
            }
        }

        return offres;
		
	}

	@Override
	public int insert(OffreDeProjet offre) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO offredeprojet (Titre, Description, Budget, Localisation, Duree,Id_employeur VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setOffreParameters(statement, offre);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
	
	}

	@Override
	public int update(OffreDeProjet offre) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE offredeprojet SET Titre = ?, Description = ?, Budget = ?, Localisation = ?, Duree = ?, Id_employeur = ?, WHERE Id_offre = ?"))
		 {

	            setOffreParameters(statement, offre);
	            statement.setInt(13, offre.getId_offre());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(OffreDeProjet t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void setOffreParameters(PreparedStatement statement, OffreDeProjet offre) throws SQLException {
    	statement.setString(1, offre.getTitre());
        statement.setString(2, offre.getDescription());
        statement.setFloat(3, offre.getBudget());
        statement.setString(4, offre.getLocalisation());
        statement.setDate(5, offre.getDuree());
        statement.setInt(6, offre.getId_employeur());

		
	}

	private OffreDeProjet mapResultSetToOffre(ResultSet resultSet) throws SQLException {
        return new OffreDeProjet(
        		resultSet.getInt("id_offre"),
                resultSet.getString("Titre"),
                resultSet.getString("Description"),
                resultSet.getFloat("Budget"),
                resultSet.getString("Localisation"),
                resultSet.getDate("Duree"),
                resultSet.getInt("Id_employeur")
        );
    }
	
	
}
