package DAO.Artisan;

public class Artisan {
	
	private int id_artisan;
	private String Nom;
	private String Prenom;
	private String Email;
	private String MotDePasse;
	private String CIN;
	private int NumeroDeTelephone;
	private float NoteGlobArtisan;
	private String adresse;
	private String Langues;
	private String Formation;
	private String ExperienceProfessionnelle;
	private String Competences;
	
	
	public Artisan( String nom, String prenom, String email, String motDePasse, String cIN,
			int numeroDeTelephone, float noteGlobArtisan, String adresse, String langues, String formation,
			String experienceProfessionnelle, String competences) {
		super();
		
		Nom = nom;
		Prenom = prenom;
		Email = email;
		MotDePasse = motDePasse;
		CIN = cIN;
		NumeroDeTelephone = numeroDeTelephone;
		NoteGlobArtisan = noteGlobArtisan;
		this.adresse = adresse;
		Langues = langues;
		Formation = formation;
		ExperienceProfessionnelle = experienceProfessionnelle;
		Competences = competences;
		
	}
	
	public Artisan(String nom2, String prenom2, String email2, String cIN2, String adresse2, String langues2,
			String formation2, String experienceProfessionnelle2, String competences2, int id_artisan2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_artisan() {
		return id_artisan;
	}
	public void setId_artisan(int id_artisan) {
		this.id_artisan = id_artisan;
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
	public float getNoteGlobArtisan() {
		return NoteGlobArtisan;
	}
	public void setNoteGlobArtisan(float noteGlobArtisan) {
		NoteGlobArtisan = noteGlobArtisan;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getLangues() {
		return Langues;
	}
	public void setLangues(String langues) {
		Langues = langues;
	}
	public String getFormation() {
		return Formation;
	}
	public void setFormation(String formation) {
		Formation = formation;
	}
	public String getExperienceProfessionnelle() {
		return ExperienceProfessionnelle;
	}
	public void setExperienceProfessionnelle(String experienceProfessionnelle) {
		ExperienceProfessionnelle = experienceProfessionnelle;
	}
	public String getCompetences() {
		return Competences;
	}
	public void setCompetences(String competences) {
		Competences = competences;
	}
	
	
}
