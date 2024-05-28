package DAO.Postulation;

public class Postulation {
	
	private int id_postulation;
	private float Montant;
	private String Message;
	private String Etat;
	private int Id_artisan;
	private int Id_offre;
	
	public Postulation(int id_postulation, float montant, String message, String etat, int id_artisan, int id_offre) {
		super();
		this.id_postulation = id_postulation;
		Montant = montant;
		Message = message;
		Etat = etat;
		Id_artisan = id_artisan;
		Id_offre = id_offre;
	}
	
	
	
	public String getEtat() {
		return Etat;
	}


	public void setEtat(String etat) {
		Etat = etat;
	}


	public int getId_artisan() {
		return Id_artisan;
	}


	public void setId_artisan(int id_artisan) {
		Id_artisan = id_artisan;
	}


	public int getId_offre() {
		return Id_offre;
	}


	public void setId_offre(int id_offre) {
		Id_offre = id_offre;
	}


	public Postulation(int id_postulation, int montant, String message) {
		super();
		this.id_postulation = id_postulation;
		Montant = montant;
		Message = message;
	}


	public Postulation() {
		// TODO Auto-generated constructor stub
	}



	public int getId_postulation() {
		return id_postulation;
	}


	


	public void setId_postulation(int id_postulation) {
		this.id_postulation = id_postulation;
	}


	public float getMontant() {
		return Montant;
	}


	public void setMontant(float montant2) {
		Montant = montant2;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}
	
	
}
