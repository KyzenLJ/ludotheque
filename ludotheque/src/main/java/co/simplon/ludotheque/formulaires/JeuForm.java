package co.simplon.ludotheque.formulaires;

public class JeuForm {
	

	private String titre;
	private String description;
	private String theme;
	private int joueur_min;
	private int joueur_max;
	private int exemplaire_catalogue;
	private int exemplaire_dispo;
	//private String mecanique;
	
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
//	public String getMecanique() {
//		return mecanique;
//	}
//	public void setMecanique(String mecanique) {
//		this.mecanique = mecanique;
//	}
	
	@Override
	public String toString() {
		return "JeuForm [titre=" + titre + ", description=" + description + ", theme=" + theme + ", joueur_min="
				+ joueur_min + ", joueur_max=" + joueur_max + ", exemplaire_catalogue="
				+ exemplaire_catalogue + ", exemplaire_dispo=" + exemplaire_dispo  + "]";
	}
	
}
