package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Jeu;

public interface JeuDao {

	// methode à utiliser dans l'implementation de JDBCJeu
	public List<Jeu> listJeux() throws Exception;
	
	public Jeu get(Long id_jeu) throws Exception;
	
	public Jeu add(Jeu jeu) throws Exception;
	
	public Jeu update(Jeu jeu) throws Exception;
	
	public void delete(Long id_jeu) throws Exception;
}
