package co.simplon.ludotheque.model;

import java.util.List;

import co.simplon.ludotheque.model.mecanique.*;

public class JeuMecanique {
	
private Long id;
private List<Mecanique> mecanique; 
private Long id_jeu;

	public JeuMecanique(Long id, List<Mecanique> mecanique, Long id_jeu) {
		super();
		this.id = id;
		this.mecanique = mecanique;
		this.id_jeu = id_jeu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Mecanique> getMecanique() {
		return mecanique;
	}

	public void setMecanique(List<Mecanique> mecanique) {
		this.mecanique = mecanique;
	}

	public Long getId_jeu() {
		return id_jeu;
	}

	public void setId_jeu(Long id_jeu) {
		this.id_jeu = id_jeu;
	}
	
	
}
