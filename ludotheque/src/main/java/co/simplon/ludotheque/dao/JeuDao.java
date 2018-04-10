package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Jeu;

public interface JeuDao {

	// methode à utiliser dans l'implementation de JDBCJeu
	public List<Jeu> listJeux() throws Exception;
	
	public Jeu getJeu(Long id_jeu) throws Exception;
	
	public Jeu addJeu(Jeu jeu) throws Exception;
	
	public Jeu updateJeu(Jeu jeu) throws Exception;
	
	public void deleteJeu(Long id_jeu) throws Exception;
}
