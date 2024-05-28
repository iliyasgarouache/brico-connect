package DAO.OffreDeProjet;

import java.sql.Date;

public class OffreDeProjet {
	private int id_offre;
	private String Titre;
	private String Description;
	private float budget;
	private String Localisation;
	private Date Duree;
	private int Id_employeur;
	
	
	public OffreDeProjet(int id_offre, String titre, String description, float budget, String localisation, Date duree,int Id_employeur) {
		super();
		this.id_offre = id_offre;
		this.Titre = titre;
		this.Description = description;
		this.budget = budget;
		this.Localisation = localisation;
		this.Duree = duree;
		this.Id_employeur=Id_employeur;
	}




	public int getId_offre() {
		return id_offre;
	}


	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}


	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public float getBudget() {
		return budget;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String getLocalisation() {
		return Localisation;
	}


	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}


	public Date getDuree() {
		return Duree;
	}


	public void setDuree(Date duree) {
		Duree = duree;
	}
	
	public int getId_employeur() {
		return Id_employeur;
	}


	public void setId_employeur(int id_employeur) {
		Id_employeur = id_employeur;
	}

	
}
