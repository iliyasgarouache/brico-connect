package DAO.Projet;

public class Projet {

	private int id_projet;
	private String EtatAvancementArtisan;
	private String EtatAvancementEmployeur;
	private float NoteArtisan;
	private float NoteEmployeur;
	private int id_postulation;
	
	
	public int getId_postulation() {
		return id_postulation;
	}


	public void setId_postulation(int id_postulation) {
		this.id_postulation = id_postulation;
	}


	public Projet(int id_projet, String etatAvancementArtisan, String etatAvancementEmployeur, float noteArtisan,
			float noteEmployeur, int id_postulation) {
		super();
		this.id_projet = id_projet;
		EtatAvancementArtisan = etatAvancementArtisan;
		EtatAvancementEmployeur = etatAvancementEmployeur;
		NoteArtisan = noteArtisan;
		NoteEmployeur = noteEmployeur;
		this.id_postulation = id_postulation;
	}



	public int getId_projet() {
		return id_projet;
	}


	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}


	public String getEtatAvancementArtisan() {
		return EtatAvancementArtisan;
	}


	public void setEtatAvancementArtisan(String etatAvancementArtisan) {
		EtatAvancementArtisan = etatAvancementArtisan;
	}


	public String getEtatAvancementEmployeur() {
		return EtatAvancementEmployeur;
	}


	public void setEtatAvancementEmployeur(String etatAvancementEmployeur) {
		EtatAvancementEmployeur = etatAvancementEmployeur;
	}


	public float getNoteArtisan() {
		return NoteArtisan;
	}


	public void setNoteArtisan(float noteArtisan) {
		NoteArtisan = noteArtisan;
	}


	public float getNoteEmployeur() {
		return NoteEmployeur;
	}


	public void setNoteEmployeur(float noteEmployeur) {
		NoteEmployeur = noteEmployeur;
	}
	
	
}
