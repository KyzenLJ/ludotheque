package co.simplon.ludotheque.model;

public class Jeu {
	
private Long id_jeu;
private String titre;
private String description;
private String theme;
private String genre1;
private String genre2;
private String genre3;
private int joueur_min;
private int joueur_max;
private boolean disponible;
private int exemplaire_catalogue;
private int exemplaire_dispo;

	public Jeu() {
		}
	
	public Jeu (Long id_jeu, String titre, String description, String theme, String genre1, String genre2, String genre3, int joueur_min, int joueur_max, boolean disponible, int exemplaire_catalogue, int exemplaire_dispo) {
		this.id_jeu = id_jeu;
		this.titre = titre;
		this.description = description;
		this.theme = theme;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.genre3 = genre3;
		this.joueur_min = joueur_min;
		this.joueur_max = joueur_max;
		this.disponible = disponible;
		this.exemplaire_catalogue = exemplaire_catalogue;
		this.exemplaire_dispo = exemplaire_dispo;
	}

	public Long getId_jeu() {
		return id_jeu;
	}

	public void setId_jeu(Long id_jeu) {
		this.id_jeu = id_jeu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

	public int getJoueur_min() {
		return joueur_min;
	}

	public void setJoueur_min(int joueur_min) {
		this.joueur_min = joueur_min;
	}

	public int getJoueur_max() {
		return joueur_max;
	}

	public void setJoueur_max(int joueur_max) {
		this.joueur_max = joueur_max;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getExemplaire_catalogue() {
		return exemplaire_catalogue;
	}

	public void setExemplaire_catalogue(int exemplaire_catalogue) {
		this.exemplaire_catalogue = exemplaire_catalogue;
	}

	public int getExemplaire_dispo() {
		return exemplaire_dispo;
	}

	public void setExemplaire_dispo(int exemplaire_dispo) {
		this.exemplaire_dispo = exemplaire_dispo;
	}
	

}
