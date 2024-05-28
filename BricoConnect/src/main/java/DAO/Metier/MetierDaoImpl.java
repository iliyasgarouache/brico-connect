package DAO.Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;



public class MetierDaoImpl implements MetierDaoInterface {

	@Override
	public Metier get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM metier WHERE 	Id_metier = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToMetier(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<Metier> getAll() throws SQLException {
		List<Metier> metiers = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM metier")) {

            while (resultSet.next()) {
                metiers.add(mapResultSetToMetier(resultSet));
            }
        }

        return metiers;
	}

	@Override
	public int insert(Metier metier) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO metier (NomMetier) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setMetierParameters(statement, metier);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
	}

	@Override
	public int update(Metier metier) throws SQLException {
		 try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE metier SET NomMetier = ? WHERE id_metier = ?"))
		 {

	            setMetierParameters(statement, metier);
	            statement.setInt(13, metier.getId_metier());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(Metier t) {
		// TODO Auto-generated method stub
		return 0;
	}
	 private void setMetierParameters(PreparedStatement statement, Metier metier) throws SQLException {
	    	statement.setString(1, metier.getNomMetier());
	        
			
		}

		private Metier mapResultSetToMetier(ResultSet resultSet) throws SQLException {
	        return new Metier(
	        		resultSet.getInt("id_metier"),
	                resultSet.getString("NomMetier")
	                

	        );
	    }
}
