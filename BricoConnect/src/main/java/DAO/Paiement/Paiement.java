package DAO.Paiement;

import java.sql.Date;

public class Paiement {
	
	private int id_paiement;
	private Date date;
	private String TypePaiement;
	private float Montant;
	
	
	public Paiement(int id_paiement, Date date, String typePaiement, float montant) {
		super();
		this.id_paiement = id_paiement;
		this.date = date;
		TypePaiement = typePaiement;
		Montant = montant;
	}


	public int getId_paiement() {
		return id_paiement;
	}


	public void setId_paiement(int id_paiement) {
		this.id_paiement = id_paiement;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTypePaiement() {
		return TypePaiement;
	}


	public void setTypePaiement(String typePaiement) {
		TypePaiement = typePaiement;
	}


	public float getMontant() {
		return Montant;
	}


	public void setMontant(int montant) {
		Montant = montant;
	}

	
}
