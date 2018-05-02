package co.simplon.ludotheque.model;

import java.util.Date;

public class Resa {
	
private Long id;
private Long id_jeu;
private Long id_compte;
private boolean honore;
private boolean rendu;
private Date debutResa;
private Date retourResaPrevu;

	public Resa() {
		}

	public Resa(Long id, Long id_jeu, Long id_compte, boolean honore, boolean rendu, Date debutResa, Date retourResaPrevu) {
		super();
		this.id = id;
		this.id_jeu = id_jeu;
		this.id_compte = id_compte;
		this.honore = honore;
		this.rendu = rendu;
		this.debutResa = debutResa;
		this.retourResaPrevu = retourResaPrevu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_jeu() {
		return id_jeu;
	}

	public void setId_jeu(Long id_jeu) {
		this.id_jeu = id_jeu;
	}

	public Long getId_compte() {
		return id_compte;
	}

	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
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
	
	public Date getDebutResa() {
		return debutResa;
	}
	
	public void setDebutResa(Date debutResa) {
		this.debutResa = debutResa;
	}
	
	public Date getRetourResaPrevu() {
		return retourResaPrevu;
	}
	
	public void setRetourResaPrevu(Date retourResaPrevu) {
		this.retourResaPrevu = retourResaPrevu;
	}
}
