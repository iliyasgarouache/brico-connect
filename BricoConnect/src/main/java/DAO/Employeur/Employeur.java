package DAO.Employeur;

public class Employeur {
	
	private int id_employeur;
	private String Nom;
	private String Prenom;
	private String Email;
	private String MotDePasse;
	private String CIN;
	private int NumeroDeTelephone;
	private float NoteGlobEmployeur;
	private String Statut;
	private String adresse;
	
	
	public Employeur(int id_employeur, String nom, String prenom, String email, String motDePasse, String cIN,
			int numeroDeTelephone, float noteGlobEmployeur, String statut, String adresse) {
		super();
		this.id_employeur = id_employeur;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		MotDePasse = motDePasse;
		CIN = cIN;
		NumeroDeTelephone = numeroDeTelephone;
		NoteGlobEmployeur = noteGlobEmployeur;
		Statut = statut;
		this.adresse = adresse;
	}


	public int getId_employeur() {
		return id_employeur;
	}


	public void setId_employeur(int id_employeur) {
		this.id_employeur = id_employeur;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		Prenom = prenom;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMotDePasse() {
		return MotDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}


	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public int getNumeroDeTelephone() {
		return NumeroDeTelephone;
	}


	public void setNumeroDeTelephone(int numeroDeTelephone) {
		NumeroDeTelephone = numeroDeTelephone;
	}


	public float getNoteGlobEmployeur() {
		return NoteGlobEmployeur;
	}


	public void setNoteGlobEmployeur(float noteGlobEmployeur) {
		NoteGlobEmployeur = noteGlobEmployeur;
	}


	public String getStatut() {
		return Statut;
	}


	public void setStatut(String Statut) {
		this.Statut = Statut;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
