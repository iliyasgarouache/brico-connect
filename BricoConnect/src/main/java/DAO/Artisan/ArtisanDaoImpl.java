package DAO.Artisan;

import DAO.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class ArtisanDaoImpl implements ArtisanDaoInterface {
   
    public Artisan get(int id) throws SQLException {
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM artisan WHERE id_artisan = ?")) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToArtisan(resultSet);
                }
            }
        }

        return null;
    }

    public List<Artisan> getAll() throws SQLException {
        List<Artisan> artisans = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM artisans")) {

            while (resultSet.next()) {
                artisans.add(mapResultSetToArtisan(resultSet));
            }
        }

        return artisans;
    }

   

    public int update(String nom, String prenom, String email, String cIN, String adresse, String langues,
			String formation, String experienceProfessionnelle, String competences, int id_artisan) throws SQLException {
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE artisan SET Nom = ?, Prenom = ?, Email = ?, CIN = ?, adresse = ?, Langues = ?,Formation = ?, ExperienceProfessionnelle = ?, Competences = ? WHERE id_artisan = ?")) {

        	statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, email);
            statement.setString(4, cIN);
            statement.setString(5, adresse);
            statement.setString(6, langues);
            statement.setString(7, formation);
            statement.setString(8, experienceProfessionnelle);
            statement.setString(9, competences);
            statement.setInt(10, id_artisan);

            return statement.executeUpdate();
        }
    }

    public int insert(Artisan artisan) throws SQLException {
    	Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO artisan (Nom, Prenom, Email, MotDePasse, CIN,NumeroDeTelephone, NoteGlobArtisan, adresse, Langues,  Formation, ExperienceProfessionnelle, Competences) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setArtisanParameters(statement, artisan);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
    }

    

    private void setArtisanParameters(PreparedStatement statement, Artisan artisan) throws SQLException {
    	statement.setString(1, artisan.getNom());
        statement.setString(2, artisan.getPrenom());
        statement.setString(3, artisan.getEmail());
        statement.setString(4, artisan.getMotDePasse());
        statement.setString(5, artisan.getCIN());
        statement.setInt(6, artisan.getNumeroDeTelephone());
        statement.setFloat(7, artisan.getNoteGlobArtisan());
        statement.setString(8, artisan.getAdresse());
        statement.setString(9, artisan.getLangues());
        statement.setString(10, artisan.getFormation());
        statement.setString(11, artisan.getExperienceProfessionnelle());
        statement.setString(12, artisan.getCompetences());
       

        

		
	}

	private Artisan mapResultSetToArtisan(ResultSet resultSet) throws SQLException {
        return new Artisan(
               
                resultSet.getString("Nom"),
                resultSet.getString("Prenom"),
                resultSet.getString("Email"),
                resultSet.getString("MotDePasse"),
                resultSet.getString("CIN"),
                resultSet.getInt("NumeroDeTelephone"),
                resultSet.getFloat("NoteGlobArtisan"),
                resultSet.getString("adresse"),
                resultSet.getString("Langues"),
                resultSet.getString("Formation"),
                resultSet.getString("ExperienceProfessionnelle"),
                resultSet.getString("Competences")
        );
    }

	@Override
	public int delete(Artisan t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int authenticate(String Email, String MotDePasse) throws SQLException {
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id_artisan FROM artisan WHERE Email = ? AND MotDePasse = ?")) {

            statement.setString(1, Email);
            statement.setString(2, MotDePasse);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_artisan");
                }
            }
        }

        return -1; // Retournez une valeur par défaut ou une valeur indiquant que l'authentification a échoué
    }

	@Override
	public int update(Artisan t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
    
}