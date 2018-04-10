package co.simplon.ludotheque.model;

public class Resa {
	
private Long id_resa;
private int id_jeu_reserve;
private int id_emprunteur;
private boolean honore;
private boolean rendu;

	public Resa() {
		}

	public Resa(Long id_resa, int id_jeu_reserve, int id_emprunteur, boolean honore, boolean rendu) {
		super();
		this.id_resa = id_resa;
		this.id_jeu_reserve = id_jeu_reserve;
		this.id_emprunteur = id_emprunteur;
		this.honore = honore;
		this.rendu = rendu;
	}

	public Long getId_resa() {
		return id_resa;
	}

	public void setId_resa(Long id_resa) {
		this.id_resa = id_resa;
	}

	public int getId_jeu_reserve() {
		return id_jeu_reserve;
	}

	public void setId_jeu_reserve(int id_jeu_reserve) {
		this.id_jeu_reserve = id_jeu_reserve;
	}

	public int getId_emprunteur() {
		return id_emprunteur;
	}

	public void setId_emprunteur(int id_emprunteur) {
		this.id_emprunteur = id_emprunteur;
	}

	public boolean isHonore() {
		return honore;
	}

	public void setHonore(boolean honore) {
		this.honore = honore;
	}

	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
	
}
