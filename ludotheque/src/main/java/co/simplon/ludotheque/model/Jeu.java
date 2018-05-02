package co.simplon.ludotheque.model;

public class Jeu {
	
private Long id;
private String titre;
private String description;
private String theme;
private int joueur_min;
private int joueur_max;
private boolean disponible;
private int exemplaire_catalogue;
private int exemplaire_dispo;

	public Jeu() {
		}
	
	public Jeu (Long id, String titre, String description, String theme, int joueur_min, int joueur_max, boolean disponible, int exemplaire_catalogue, int exemplaire_dispo) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.theme = theme;
		this.joueur_min = joueur_min;
		this.joueur_max = joueur_max;
		this.disponible = disponible;
		this.exemplaire_catalogue = exemplaire_catalogue;
		this.exemplaire_dispo = exemplaire_dispo;
	}

	public Long getId_jeu() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
