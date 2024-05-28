package DAO.Metier;

public class Metier {
	
	private int id_metier;
	private String NomMetier;
	
	
	public Metier(int id_metier, String nomMetier) {
		super();
		this.id_metier = id_metier;
		NomMetier = nomMetier;
	}


	public int getId_metier() {
		return id_metier;
	}


	public void setId_metier(int id_metier) {
		this.id_metier = id_metier;
	}


	public String getNomMetier() {
		return NomMetier;
	}


	public void setNomMetier(String nomMetier) {
		NomMetier = nomMetier;
	}
	
	
}
