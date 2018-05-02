package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Compte;

public interface CompteDao {
	// methode à utiliser dans l'implementation de JDBCCompte
	public List<Compte> listComptes() throws Exception;
	
	public Compte get(Long id_compte) throws Exception;
	
	public Compte add(Compte compte) throws Exception;
	
	public Compte update(Compte compte) throws Exception;
	
	public void delete(Long id_compte) throws Exception;
}

