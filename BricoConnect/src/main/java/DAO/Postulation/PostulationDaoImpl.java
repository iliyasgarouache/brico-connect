package DAO.Postulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;


public class PostulationDaoImpl implements PostulationDaoInterface {

	@Override
	public Postulation get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM postulation WHERE Id_postulation = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToPostulation(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<Postulation> getAll() throws SQLException {
		List<Postulation> postulations = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM postulation")) {

            while (resultSet.next()) {
                postulations.add(mapResultSetToPostulation(resultSet));
            }
        }

        return postulations;
	}

	public int insert(Float Montant, String Message, int Id_artisan, int Id_offre) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO postulation (Montant, Message, Id_artisan, Id_offre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

        	statement.setFloat(1, Montant);
            statement.setString(2, Message);
            statement.setInt(3, Id_artisan);
            statement.setInt(4, Id_offre);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
	}

	@Override
	public int update(Postulation postulation) throws SQLException {
		 try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE postulation SET Montant = ?, Message = ?, Etat = ?, Id_artisan = ?, Id_offre = ? WHERE id_postulation = ?"))
		 {

	            setPostulationParameters(statement, postulation);
	            statement.setInt(13, postulation.getId_postulation());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(Postulation t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 private void setPostulationParameters(PreparedStatement statement, Postulation postulation) throws SQLException {
	    	statement.setFloat(1, postulation.getMontant());
	        statement.setString(2, postulation.getMessage());
	        statement.setString(3, postulation.getEtat());
	        statement.setInt(4, postulation.getId_artisan());
	        statement.setInt(5, postulation.getId_offre());
		}

		private Postulation mapResultSetToPostulation(ResultSet resultSet) throws SQLException {
	        return new Postulation(
	        		resultSet.getInt("id_postulation"),
	                resultSet.getFloat("Montant"),
	                resultSet.getString("Message"),
	                resultSet.getString("Etat"),
	                resultSet.getInt("id_artisan"),
	                resultSet.getInt("id_offre")
	               

	        );
	    }

		@Override
		public int insert(Postulation t) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
	
	
}
