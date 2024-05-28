package DAO.Paiement;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoFactory;


public class PaiementDaoImpl implements PaiementDaoInterface{

	@Override
	public Paiement get(int id) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement("SELECT * FROM paiement WHERE Id_paiement = ?")) {

	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToPaiement(resultSet);
	                }
	            }
	        }

	        return null;
	}

	@Override
	public List<Paiement> getAll() throws SQLException {
		List<Paiement> paiements = new ArrayList<>();

        try (Connection connection = DaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM paiement")) {

            while (resultSet.next()) {
                paiements.add(mapResultSetToPaiement(resultSet));
            }
        }

        return paiements;
	}

	@Override
	public int insert(Paiement paiement) throws SQLException {
		Connection connection = DaoFactory.getConnection();
    	String sql="INSERT INTO paiement (Date, TypePaiement, Montant ) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            setPaiementParameters(statement, paiement);

             int rowsAffected = statement.executeUpdate();

            return rowsAffected;
        }
	}

	@Override
	public int update(Paiement paiement) throws SQLException {
		try (Connection connection = DaoFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE paiement SET Date = ?, TypePaiement=?, Montant=? WHERE id_paiement = ?"))
		 {

	            setPaiementParameters(statement, paiement);
	            statement.setInt(13, paiement.getId_paiement());

	            return statement.executeUpdate();
	        }
	}

	@Override
	public int delete(Paiement t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 private void setPaiementParameters(PreparedStatement statement, Paiement paiement) throws SQLException {
	    	statement.setDate(1, paiement.getDate());
	        statement.setString(2, paiement.getTypePaiement());
	        statement.setFloat(3, paiement.getMontant());
			
		}

		private Paiement mapResultSetToPaiement(ResultSet resultSet) throws SQLException {
	        return new Paiement(
	        		resultSet.getInt("id_paiement"),
	                resultSet.getDate("Date"),
	                resultSet.getString("TypePaiement"),
	                resultSet.getFloat("Montant")
	           

	        );
	    }
	

}
